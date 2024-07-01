import java.util.*;
import java.io.*;

public class baekjoon_9020_김동환 {
    public static boolean[] arr = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        solution();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int a = n / 2;
            int b = n / 2;
            while (true) {
                if (!arr[a] && !arr[b]) {
                    sb.append(a).append(' ').append(b).append('\n');
                    break;
                }
                a--;
                b++;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void solution() {
        arr[0] = arr[1] = true; // 0과 1은 소수아님.
        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i]) continue; // 어차피 돌렷을때 소수라면 넘어감;
            for (int j = i * i; j < arr.length; j += i) {
                arr[j] = true; // 2부터 돌려서 그 배수들은 다 소수가 아님(2를 약수로가지니까.)
            }
        }
    }
}
