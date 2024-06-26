// N명을 N/2 로 나누어서 스타트와 링크팀으로 나누어야함
// 1부터 N까지 배정, i번과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치
// 능력치의 차이를 가장 적게했을때의 차이값
// 그럼 어차피 인원수는 같아야하니까
// 반절로 나눈 인원수에서 그 개수별 부분집합 구해서 차이 가장 적은 값으로 내보내면 안될까 

import java.util.*;
import java.io.*;

public class Main  {
    static int N;
    static boolean[] visited;
    static int[][] scores;
    static int mini = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        scores = new int[N+1][N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0, 1);
        bw.write(String.valueOf(mini));
        bw.flush();
        br.close();
        bw.close();

    }
    static void solution(int idx, int cnt) {
        if (idx == N / 2) {
            mini = Math.min(mini, getResult());
            return;
        }
        for (int i = cnt; i < N; i++) {
            visited[i] = true;
            solution(idx+1, i+1);
            visited[i] = false;
        }
    }

    static int getResult() {
        int start = 0;
        int end = 0;

        for (int i =1; i<=N; i++) {
            for (int j = 1; j<=N; j++) {
                if (i == j) continue;

                if(visited[i] && visited[j]) {
                    start += scores[i][j];
                }
                if(!visited[i] && !visited[j]) {
                    end += scores[i][j];
                }
            }
        }
        return Math.abs(start - end);
    }
}
