package _1주차;

import java.util.*;
import java.io.*;
public class Baekjoon_4344_이승민 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = 0;
            int[] scores = new int[n];
            for (int j = 0; j < n; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }
            double avg = (double) sum / n;
            int overAvg = 0;
            for (int j = 0; j < n; j++) {
                if (scores[j] > avg) {
                    overAvg++;
                }
            }
            double percent = (double) overAvg / n * 100;
            sb.append(String.format("%.3f", percent)).append("%").append("\n");
        }
        System.out.println(sb);
    }
}
