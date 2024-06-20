import java.io.*;
import java.util.*;
// 나이트가 할 수 있는 이동은 총 8가지이다.
// bfs 로 가면 될듯 (나이트가 이동할 수 있는 경우마다 cnt + 1)
// 최소 이동횟수이니까 최단 경로와 같다고 보면 된다.
// 출력값이 횟수일뿐

public class Main {
    // 몇행 몇열인지
    static int I = 0;
    // 나이트의 좌표값
    static int x1, x2, y1, y2;
    // 체스판과 방문위치
    static int[][] map;
    static boolean[][] visited;
    // 나이트의 이동 경우의수
    static int[] deltaX = {1,2,2,1,-1,-2,-2,-1};
    static int[] deltaY = {2,1,-1,-2,-2,-1,1,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i=1; i <= T; i++) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bfs();

            sb.append(map[x2][y2]).append('\n');
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1});
        visited[x1][y1] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i=0; i < 8; i++){
                int ox = nx + deltaX[i];
                int oy = ny + deltaY[i];

                if (ox >= 0 && oy >= 0 && ox < I && oy < I) {
                    if (!visited[ox][oy]) {
                        q.add(new int[] {ox, oy});
                        map[ox][oy] = map[nx][ny] + 1;
                        visited[ox][oy] = true;
                    }
                }

            }
        }
    }
}