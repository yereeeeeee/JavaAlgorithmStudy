package Algorithm3;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class baekjoon_7562_정훈 {
	static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

    public static int bfs(int sx, int sy, int ex, int ey, int size) {
        int[][] visited = new int[size][size]; 
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy}); 
        visited[sx][sy] = 1; 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == ex && y == ey) {
                return visited[x][y] - 1; 
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < size && ny < size && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 

        for (int t = 0; t < T; t++) {
            int size = scanner.nextInt(); 
            int sx = scanner.nextInt(); 
            int sy = scanner.nextInt(); 
            int ex = scanner.nextInt(); 
            int ey = scanner.nextInt(); 

            int result = bfs(sx, sy, ex, ey, size);
            System.out.println(result);
        }

        scanner.close();
    }
}