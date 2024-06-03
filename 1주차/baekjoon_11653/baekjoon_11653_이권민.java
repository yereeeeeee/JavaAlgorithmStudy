import java.util.Scanner;
// 입력받기 위한 클래스

public class Main {
    public static void main(String[] args) {
        // 코드는 클래스 내에 작성
        // public static void main(String[] args) 프로그램의 시작점 정의
        Scanner in = new Scanner(System.in);
        // 객체 선언
        int num = in.nextInt();
        int i = 2;

        while (num > 1) {
            if (num % i == 0) {
                num = num / i;
                System.out.println(i);
            } else {
                i++;
            }
        }

        in.close();
    }
}
