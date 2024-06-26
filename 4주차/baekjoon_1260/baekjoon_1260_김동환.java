import java.io.*;
import java.util.*;

// 첫줄엔 dfs 를 수행한 결과
// 다음줄에 bfs 를 수행한 결과

public class Main {

    public static int[][] graph; // 입력받을 그래프
    public static boolean[] visit; // 방문 저장
    public static StringBuilder sb = new StringBuilder(); // 출력할거
    public static Queue<Integer> queue = new LinkedList<>(); // bfs에 사용할 큐
    public static int N; // 입력값 1 (정점의 개수)
    public static int M; // 입력값 2 (간선의 개수)
    public static int V; // 입력값 3 (시작점)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽을거
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력할거
        StringTokenizer st = new StringTokenizer(br.readLine()); // 처음 한줄에 3개 저장되어서 이걸로 받아
        // 각 입력으로 저장
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken()); 
        // 그래프는 정점 보다 1개 많게 만들고, 방문값도 마찬가지
        graph = new int[N+1][N+1];
        visit = new boolean[N+1];
        // 그리고 간선의 개수 만큼 돌면서
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
    
            graph[x][y] = graph[y][x] = 1; // 양방향 리스트 생성
        }

        // dfs와 bfs를 만들어서 돌리면 되겠다는 생각
        dfs(V);
        Arrays.fill(visit, false);
        bfs(V);
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int num) {
        // 들어오는 순간 방문처리
        visit[num] = true;
        // 출력할거에 넣어주면 되지(방문한거니까)
        sb.append(num).append(" ");
        for (int i=1; i <= N; i++) {
            // 정점 돕니다.
            // 연결되어있고, 가본적 없으면 방문하기
            if (graph[num][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int num) {
        // 무작정 큐에 넣음
        queue.add(num);
        visit[num] = true;
        // 이건 dfs 결과 다음 줄바꿈위해서 \n 추가
        sb.append('\n').append(num).append(" ");
        // 큐가 빌때까지 반복
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i <= N; i ++) {
                if (graph[now][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}