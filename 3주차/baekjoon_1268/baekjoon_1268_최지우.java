package Java_03_hw;

import java.util.*;
import java.io.*;

public class baekjoon_1268_최지우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] stu = new int[n][5];

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                stu[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] cnt = new int[n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i != j) {
                    for (int k=0; k<5; k++) {
                        if (stu[i][k] == stu[j][k]) {
                            cnt[i]++;
                            break;
                        }
                    }
                }
            }
        }
        int max = -1;
        int result = 0;

        for (int i=0; i<n; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                result = i+1;
            }
        }
        System.out.println(result);
    }
}
