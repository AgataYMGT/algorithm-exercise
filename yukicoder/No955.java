import java.util.Scanner;

public class No955 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		if(a == 0) {
			if(b == 0) {
				if(c == 0) {
					System.out.println(-1);
					return;
				} else {
					System.out.println(0);
					return;
				}
			} else {
				System.out.println(1);
				System.out.println(-c);
				return;
			}
		}

		long D = b * b - 4 * a * c;
		if(D > 0) {
			System.out.println(2);
			System.out.println((-b - Math.pow(D, 0.5f)) / 2 / a);
			System.out.println((-b + Math.pow(D, 0.5f)) / 2 / a);
		} else if(D == 0) {
			System.out.println(1);
			System.out.println((int)(-b + Math.pow(D, 0.5f)) / 2 / a);
		} else {
			System.out.println(0);
		}
	}

}
