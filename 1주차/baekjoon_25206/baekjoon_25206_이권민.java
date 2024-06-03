import java.io.*;
// 입출력용
import java.util.StringTokenizer;
// 문자열을 작은 단위로 분리

public class Main {
    public static void main(String[] args) throws IOException {
        // throws IOException은 입출력 예외 혀용 용
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        // InputStreamReader 바이트 스트림을 문자 스트림으로 변환.

        String str[] = new String[20];
        double totalSum = 0;
        double scoreSum = 0;
        String gradeList[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        double gradeScore[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};

        for (int i = 0; i < 20; i++) {
            str[i] = bfr.readLine();
            StringTokenizer st = new StringTokenizer(str[i], " ");
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            // 형변환, nextToken은 호출할 때마다 다음 토큰으로
            String grade = st.nextToken();

            for (int j = 0; j < 10; j++) {
                if (grade.equals(gradeList[j])) {
                    totalSum += score * gradeScore[j];
                    if (j != 9) {
                        scoreSum += score;
                    }
                }
            }
        }

        double average = totalSum / scoreSum;
        System.out.printf("%.6f\n", average);

        bfr.close();
    }
}