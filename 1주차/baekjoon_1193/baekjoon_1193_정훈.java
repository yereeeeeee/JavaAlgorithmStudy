package Algorithm1;

import java.util.Scanner;

public class baekjoon_1193_정훈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        int diagonal = 0;
        int sum = 0;

        // 대각선 번호 찾기
        while (sum < X) {
            diagonal++;
            sum += diagonal;
        }

        // 대각선 내에서의 위치
        int positionInDiagonal = X - (sum - diagonal);

        // 분수 계산
        int numerator, denominator;
        if (diagonal % 2 == 0) {
            // 짝수 대각선
            numerator = positionInDiagonal;
            denominator = diagonal - positionInDiagonal + 1;
        } else {
            // 홀수 대각선
            numerator = diagonal - positionInDiagonal + 1;
            denominator = positionInDiagonal;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
