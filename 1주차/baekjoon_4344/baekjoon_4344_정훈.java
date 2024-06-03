package Algorithm1;

import java.util.Scanner;

public class baekjoon_4344_정훈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt(); // 테스트 케이스의 개수
        
        for (int i = 0; i < C; i++) {
            int N = sc.nextInt(); // 학생 수
            int[] scores = new int[N];
            int sum = 0;
            
            for (int j = 0; j < N; j++) {
                scores[j] = sc.nextInt();
                sum += scores[j];
            }
            
            double average = (double) sum / N;
            int countAboveAverage = 0;
            
            for (int j = 0; j < N; j++) {
                if (scores[j] > average) {
                    countAboveAverage++;
                }
            }
            
            double ratio = (double) countAboveAverage / N * 100;
            System.out.printf("%.3f%%\n", ratio);
        }
        
        sc.close();
    }
}
