// 규칙은 그냥 대각선으로 뒤집어 진다고 생각하면된다
// 그냥 행과 열, 2차원 배열임
// 그냥 지그재그 순서로 커지는거면, 각 대각선 칸의 개수랑, 누적합 정도?

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        
        int cross_count = 1, prev_count_sum = 0;

        while (true) {

            if (X<= prev_count_sum + cross_count) {

                if (cross_count % 2 == 1) {
                System.out.print((cross_count - (X - prev_count_sum - 1)) + "/" + (X - prev_count_sum));
                break;
            }
            

            else {
                // 홀수면 그냥 반대 출력
                System.out.print((X-prev_count_sum) + "/" + (cross_count - (X - prev_count_sum - 1)));
                break;
            }
            } else {
                prev_count_sum += cross_count;
                cross_count++;
            }
        } 
    }
}
