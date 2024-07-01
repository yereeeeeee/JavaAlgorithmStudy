package Algorithm5;

import java.util.*;

public class baekjoon_9020_정훈 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        // 소수를 미리 구함
        int MAX = 10000;
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int a = 0, b = 0;
            
            for (int i = 2; i <= n / 2; i++) {
                if (isPrime[i] && isPrime[n - i]) {
                    a = i;
                    b = n - i;
                }
            }
            
            System.out.println(a + " " + b);
        }
        
        sc.close();
    }
}
