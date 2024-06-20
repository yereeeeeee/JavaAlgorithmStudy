import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][][] lst = new int[21][21][21];

        // 기본 값 설정
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int l = 0; l <= 20; l++) {
                    if (i <= 0 || j <= 0 || l <= 0) {
                        lst[i][j][l] = 1;
                    } else if (i < j && j < l) {
                        lst[i][j][l] = lst[i][j][l - 1] + lst[i][j - 1][l - 1] - lst[i][j - 1][l];
                    } else {
                        lst[i][j][l] = lst[i - 1][j][l] + lst[i - 1][j - 1][l] + lst[i - 1][j][l - 1] - lst[i - 1][j - 1][l - 1];
                    }
                }
            }
        }

        // 무한 루프
        while (true) {
            // 입력을 받아서 a, b, c에 저장
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (a == -1 && b == -1 && c == -1) {
                break;
            } else if (a <= 0 || b <= 0 || c <= 0) {
                bw.write("w(" + a + ", " + b + ", " + c + ") = 1\n");
            } else {
                // 범위를 초과하는 경우
                if (a > 20 || b > 20 || c > 20) {
                    bw.write("w(" + a + ", " + b + ", " + c + ") = " + lst[20][20][20] + "\n");
                } else {
                    bw.write("w(" + a + ", " + b + ", " + c + ") = " + lst[a][b][c] + "\n");
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
