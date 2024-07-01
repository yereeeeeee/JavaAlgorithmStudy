package Java_05_hw;

import java.util.*;
import java.io.*;

public class baekjoon_9020_최지우 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= 10000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 10000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int a = n / 2;
            int b = n / 2;

            while (true) {
                if (isPrime[a] && isPrime[b]) {
                    sb.append(a).append(" ").append(b).append("\n");
                    break;
                }
                a--;
                b++;
            }
        }

        System.out.println(sb);
    }
}
