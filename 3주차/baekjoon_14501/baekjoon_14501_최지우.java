package Java_03_hw;

import java.util.*;
import java.io.*;

public class baekjoon_14501_최지우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] tp = new int[n][2];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            tp[i][0] = Integer.parseInt(st.nextToken());
            tp[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        int result = 0;

        for (int i=0; i<n; i++) {
            for (int j=i+tp[i][0]; j<n+1; j++) {
                if (dp[j] < dp[i] + tp[i][1]) {
                    dp[j] = dp[i] + tp[i][1];
                }
            }
        }
        System.out.println(dp[n]);
    }
}
