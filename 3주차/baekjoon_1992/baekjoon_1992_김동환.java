import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 배열의 크기
        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = s.charAt(j) - '0'; 
            }
        }
        solution(N,0,0);
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solution(int n, int r, int c) {
        int one = 0;
        int zero = 0;

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] == 1) one++;
                else zero++;
            }
        }

        if (one == n * n) {
            result += '1';
            return;
        }
        if (zero == n * n) {
            result += '0';
            return;
        }

        result += "(";
        solution(n / 2, r, c);
        solution(n / 2, r, c + n / 2);
        solution(n / 2, r + n / 2, c);
        solution(n / 2, r + n / 2, c + n / 2);
        result += ')';
    }
}
