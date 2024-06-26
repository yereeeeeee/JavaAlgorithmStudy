import java.util.*;
import java.io.*;

class Edge {
    int s, e;

    Edge (int s, int e) {
        this.s = s;
        this.e = e;
    }
}

public class baekjoon_1260_최지우 {
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m, v;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n+1];
        dfs(v);
        sb.append("\n");

        visited = new boolean[n+1];
        bfs(v);

        System.out.println(sb);
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        for (int next: graph.get(v)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int v) {
        visited[v] = true;
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);

        while (!que.isEmpty()) {
            int now = que.poll();
            sb.append(now).append(" ");
            for (int next: graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.offer(next);
                }
            }
        }
    }
}
