package Java_03_hw;

import java.io.*;

public class baekjoon_9184_최지우 {
    static int[][][] dp = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                for (int k = 0; k <= 100; k++) {
                    if (i <= 50 || j <= 50 || k <= 50) {
                        dp[i][j][k] = 1;
                    } else if (i > 70 || j > 70 || k > 70) {
                        dp[i][j][k] = 1048576;
                    } else if (i < j && j < k) {
                        dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
                    } else {
                        dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
                    }
                }
            }
        }

        String input;
        while (!(input = br.readLine()).equals("-1 -1 -1")) {
            String[] parts = input.split(" ");
            int a = Integer.parseInt(parts[0]) + 50;
            int b = Integer.parseInt(parts[1]) + 50;
            int c = Integer.parseInt(parts[2]) + 50;
            System.out.println("w(" + parts[0] + ", " + parts[1] + ", " + parts[2] + ") = " + dp[a][b][c]);
        }
    }
}