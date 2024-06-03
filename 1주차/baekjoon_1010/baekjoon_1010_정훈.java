package Algorithm1;
	
import java.util.Scanner;

public class baekjoon_1010_정훈 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 개수
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // 서쪽 사이트 개수
            int M = sc.nextInt(); // 동쪽 사이트 개수
            
            System.out.println(combination(M, N));
        }
        
        sc.close();
    }
    
    // 동적 프로그래밍을 사용하여 조합 계산
    public static long combination(int n, int k) {
        if (k > n - k) {
            k = n - k; // 조합의 대칭성 활용
        }
        
        long[][] dp = new long[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        
        return dp[n][k];
    }
}
