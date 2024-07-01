package Java_05_hw;

import java.util.*;
import java.io.*;

public class baekjoon_14425_최지우 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<String> dict = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            dict.add(word);
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String checkWord = br.readLine();
            if (dict.contains(checkWord)) cnt++;
        }

        System.out.println(cnt);
    }
}
