import java.io.*;
import java.util.*;

// 백준이는 퇴사를 하는데, N + 1일이 되는 날 퇴사를 하기 위해, 남은 N일 동안 최대한 상담 하려함.
// 각 상담을 완료하는데 걸리는 기간 T와 금액 P로 이루어짐.
// 그럼 그냥 1. 상담을 할 수 있는 최대 이익을 구해라
// 상담하는데 걸리는 기간과 비용
// N+1을 maxi 값으로 준다.


public class Main {
    static int n; // 몇일 있는데
    static int[] t; // 이건 상담 시간 배열
    static int[] p; // 이건 수익 배열
    static int max_money = Integer.MIN_VALUE; // 이걸로 갱신해줄거 (최대 수익)

    static void solution(int k, int money) {
        // 종료 조건
        if (k > n) return; // 종료일수 보다 커지면 (N+1에는 없기 때문에)
        if (k == n) { // 정확히 종료 조건에 안착했을때
            max_money = Math.max(max_money, money);
            return;
        }

        solution(k + t[k], money + p[k]); // 이건 그날 상담을 한걸로함
        solution(k + 1, money); // 이건 그 상담 넘어감
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        
        solution(0,0);
        bw.write(String.valueOf(max_money));

        bw.flush();
        bw.close();
        br.close();
    }
}