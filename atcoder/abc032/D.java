import java.util.Scanner;

/**
 * https://abc032.contest.atcoder.jp/tasks/abc032_d
 */
public class Main {

    static long[] v;
    static long[] w;
    static int N;
    static long W;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = sc.nextLong();
        v = new long[N];
        w = new long[N];
        for(int i = 0; i < N; i++) {
            v[i] = sc.nextLong();
            w[i] = sc.nextLong();
        }

        System.out.println(rec(0, W));
    }

    public static long rec(int i, long j) {
        /* 品物は 0〜N-1 個目まであり、即ち N 個以上は「使える品が無い」として 0 である */
        if(i == N) {
            return 0;
        /* 品物が容量不足で入れられないとき、入れないまま次の品物を入れる */
        } else if(j < w[i]) {
            return rec(i + 1, j);
        } else {
            return Math.max(v[i] + rec(i + 1, j - w[i]), rec(i + 1, j));
        }
    }
}
