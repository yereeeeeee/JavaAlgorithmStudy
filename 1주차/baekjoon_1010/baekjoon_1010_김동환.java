// 한 사이트에 한 다리만 놓을 수 있다
// 서로 다른 다리가 겹치면 안된다.
// 그럼 M개에서 다리를 놓을 수 있는 최대점을 놓으면 최대 다리를 놓게된다.
// 그럼 dp로 구하면 되니까 dp[n+1][r+1] = dp[n][r+1] 이런 느낌이 될 거 같은데
import java.io.*;
import java.util.*;

public class Main {
    // 배열 선언함 dp에 조합값을 저장할거다.
    private static int [][] dp = new int[30][30];
    // 함수를 만들어봄
    private static void makeDp() {
        // 이건 i개중 i개를선택하거나 0개를 선택하는 경우의 수가 항상 0이다.
        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        // 조합공식으로 계산하게 된다.
        for (int i = 2; i < 30; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 입력받기 (그냥 찾아보고함)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // 함수 사용
        makeDp();
        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());
        // 테스트 케이스 돈다.
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            // 그냥 읽어서 stringbuilder 에 저장함
            sb.append(dp[M][N]).append('\n');
        }
        // 그 값을 출력함
        System.out.println(sb);

    }
}
