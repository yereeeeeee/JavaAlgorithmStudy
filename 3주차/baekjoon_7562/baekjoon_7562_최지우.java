package Java_03_hw;

import java.util.*;
import java.io.*;

public class baekjoon_7562_최지우 {
    static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc=0; tc<t; tc++) {
            int l = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());

            System.out.println(bfs(l, sx, sy, fx, fy));
        }
    }

    public static int bfs(int l, int sx, int sy, int fx, int fy) {
        if (sx == fx & sy == fy) {
            return 0;
        }

        boolean[][] visited = new boolean[l][l];
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < l && ny >= 0 && ny < l && !visited[nx][ny]) {
                    if (nx == fx && ny == fy) {
                        return dist + 1;
                    }
                    que.add(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}
