import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://abc032.contest.atcoder.jp/tasks/abc032_d
 */
public class D {

    static long[] v;
    static long[] w;
    static int N;
    static int W;
    static Map<Integer, Map<Long, Long>> calculated;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = sc.nextInt();
        v = new long[N];
        w = new long[N];
        calculated = new HashMap<>();
        for(int i = 0; i < N; i++) {
            v[i] = sc.nextLong();
            w[i] = sc.nextLong();
        }
        for(int i = 0; i < N + 1; i++) {
            calculated.put(i, new HashMap<Long, Long>());
        }

        System.out.println(rec(0, W));
    }

    public static Long rec(int i, long j) {
        Long res = calculated.get(i).get(j);
        if(res != null) {
            return res;
        }

        /* 品物は 0〜N-1 個目まであり、即ち N 個以上は「使える品が無い」として 0 である */
        if(i == N) {
            res = 0L;
        /* 品物が容量不足で入れられないとき、入れないまま次の品物を入れる */
        } else if(j < w[i]) {
            res = rec(i + 1, j);
        } else {
            res = Math.max(v[i] + rec(i + 1, j - w[i]), rec(i + 1, j));
        }

        calculated.get(i).put(j, res);
        return res;
    }

}
