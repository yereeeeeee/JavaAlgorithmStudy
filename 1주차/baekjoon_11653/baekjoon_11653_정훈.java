package Algorithm1;

import java.util.Scanner;

public class baekjoon_11653_정훈 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        if (N == 1) {
            return;
        }
        
        // 2부터 시작하여 가능한 소수로 나눈다
        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                System.out.println(i);
                N /= i;
            }
        }
        
        // 마지막에 남은 소수가 있을 경우 출력
        if (N > 1) {
            System.out.println(N);
        }
    }
}
