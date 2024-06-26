import java.io.*;
import java.util.*;

public class baekjoon_18429_최지우 {
    private static int n, k, result;
    private static int[] ws;
    private static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ws = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ws[i] = Integer.parseInt(st.nextToken());
        }
        used = new boolean[n];

        backtrack(-1, 0, 0);
        System.out.println(result);
    }
    private static void backtrack(int idx, int weight, int day) {
        if (day == 0) {
        } else {
            weight -= k;
            if (weight < 0) {
                return;
            }
            if (day == n) {
                result += 1;
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(i, weight+ws[i], day+1);
                used[i] = false;
            }
        }
    }
}
