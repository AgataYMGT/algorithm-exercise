import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();

		if(n == 1) {
			System.out.println("Not Prime");
		} else if(n == 2) {
			System.out.println("Prime");
		} else if(n % 2 == 0 || n % 5 == 0) {
			System.out.println("Not Prime");
		} else {
			for(int i = 3; i <= Math.sqrt(n); i += 2) {
				if(n % i == 0) {
					System.out.println((sumDigits(n) % 3 == 0) ? "Not Prime" : "Prime");
					return;
				}
			}
			System.out.println("Prime");
		}
	}

	public static int sumDigits(int n) {
		int sum = 0;

		while(n != 0) {
			sum += n % 10;
			n /= 10;
		}

		return sum;
	}

}
