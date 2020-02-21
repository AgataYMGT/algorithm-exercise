import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Huffman {

	public static void main(String[] args) {
		String source = new Scanner(System.in).nextLine();

		System.out.println(encodeToHuffman(source).toString());
	}

	public static Map<String, String> encodeToHuffman(String str) {
		/* 文字列の出現回数を Map に出力 */
		Map<String, Integer> probability = Stream.of(str.split(""))
				.collect(Collectors.toMap(k -> k, v -> 1, (v1, v2) -> v1 + v2, LinkedHashMap::new));

		/* すべて同じレターなら 0 を返す */
		if(probability.size() == 1) {
			String letter = probability.keySet().stream().findFirst().get();
			Map<String, String> onePairMap = new HashMap<>();

			onePairMap.put(letter, "0");
			return onePairMap;
		}

		/* 最小ヒープを作成 */
		PriorityQueue<HuffmanTreeNode> queue = new PriorityQueue<>(new HuffmanComparator());
		for(Entry<String, Integer> entry : probability.entrySet()) {
			HuffmanTreeNode node = new HuffmanTreeNode();

			node.character = entry.getKey();
			node.frequency = entry.getValue();
			node.left = null;
			node.right = null;

			queue.add(node);
		}

		while(queue.size() > 1) {
			/* 一番頻度の小さい文字を取り出す */
			HuffmanTreeNode min = queue.poll();
			/* 二番目に頻度の小さい文字を取り出す */
			HuffmanTreeNode secondMin = queue.poll();

			/* 接点を作る */
			HuffmanTreeNode root = new HuffmanTreeNode();
			root.left = min;
			root.right = secondMin;
			root.frequency = min.frequency + secondMin.frequency;
			root.character = "";

			/* 接点をキューに加える */
			queue.add(root);
		}

		Map<String, String> encodedMap = new HashMap<>();
		recursiveWritingPatterns(encodedMap, queue.poll(), "");

		return encodedMap;
	}

	private static void recursiveWritingPatterns(Map<String, String> encodedMap, HuffmanTreeNode node, String bitPatterns) {
		if(node.left == null && node.right == null) {
			encodedMap.put(node.character, bitPatterns);
			return;
		}

		recursiveWritingPatterns(encodedMap, node.left, bitPatterns + "0");
		recursiveWritingPatterns(encodedMap, node.right, bitPatterns + "1");
	}

	static class HuffmanTreeNode {
		String character;
		int frequency;

		HuffmanTreeNode left;
		HuffmanTreeNode right;
	}

	static class HuffmanComparator implements Comparator<HuffmanTreeNode> {

		@Override
		public int compare(HuffmanTreeNode arg0, HuffmanTreeNode arg1) {
			return arg0.frequency - arg1.frequency;
		}

	}

}
