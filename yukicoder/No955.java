import java.math.BigDecimal;
import java.math.RoundingMode;
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

		BigDecimal A = new BigDecimal(a);
		BigDecimal B = new BigDecimal(b);
		BigDecimal C = new BigDecimal(c);

		BigDecimal D = new BigDecimal(b);
		D = D.multiply(B).subtract(new BigDecimal(4).multiply(A).multiply(C));

		if(D.compareTo(BigDecimal.ZERO) == 1) {
			System.out.println(2);
			System.out.println(BigDecimal.ZERO.subtract(B).subtract(sqrt(D)).divide(new BigDecimal(2).multiply(A), 20, RoundingMode.HALF_EVEN));
			System.out.println(BigDecimal.ZERO.subtract(B).add(sqrt(D)).divide(new BigDecimal(2).multiply(A), 20, RoundingMode.HALF_EVEN));
		} else if(D.compareTo(BigDecimal.ZERO) == 0) {
			System.out.println(1);
			System.out.println(BigDecimal.ZERO.subtract(B).divide(new BigDecimal(2).multiply(A), 20, RoundingMode.HALF_EVEN));
		} else {
			System.out.println(0);
		}
	}

	public static BigDecimal sqrt(BigDecimal a) {
		BigDecimal a2 = a.add(BigDecimal.ZERO);

		for(int i = 0; i < 50; i++) {
			a2 = a2.subtract(a2.pow(2).subtract(a).divide(a2.multiply(new BigDecimal(2)), 20, RoundingMode.HALF_EVEN));
		}
		return a2;
	}

}
