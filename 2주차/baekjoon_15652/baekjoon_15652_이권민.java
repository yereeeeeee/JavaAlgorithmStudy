import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visit;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        arr = new int[m];
        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            // enhanced for loop. 요소만 꺼내기/
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            visit[i] = true;
            arr[depth] = i + 1;
            dfs(depth + 1, i);
            visit[i] = false;
        }
    }
}