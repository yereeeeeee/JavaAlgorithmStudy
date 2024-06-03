package _1주차;

import java.util.*;
import java.io.*;

public class Baekjoon_2851_이승민 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int mini = 100 - first;
        int sum = first;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            if (sum + now == 100) {
                System.out.println(100);
                return;
            }
            if (Math.abs(100 - sum - now) <= mini) {
                mini = Math.abs(100 - sum - now);
                sum += now;
            } else {
                System.out.println(sum);
                return;
            }
        }
        System.out.println(sum);
    }
}
