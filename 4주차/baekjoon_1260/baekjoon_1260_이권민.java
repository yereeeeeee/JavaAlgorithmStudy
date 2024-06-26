package 4주차.baekjoon_1260;

import java.io.*;
import java.util.*;

public class baekjoon_1260_이권민 {
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // Number of nodes
        int M = Integer.parseInt(st.nextToken()); // Number of edges
        int V = Integer.parseInt(st.nextToken()); // Starting node

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V, N);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V, N);
        System.out.println();
    }

    public static void dfs(int node, int N) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 1; i <= N; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i, N);
            }
        }
    }

    public static void bfs(int start, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int i = 1; i <= N; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

// 인접리스트
// package 4주차.baekjoon_1260;

// import java.io.*;
// import java.util.*;

// public class baekjoon_1260_이권민 {
//     static boolean[] visited;
//     static ArrayList<Integer>[] graph;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//         int N = Integer.parseInt(st.nextToken()); // Number of nodes
//         int M = Integer.parseInt(st.nextToken()); // Number of edges
//         int V = Integer.parseInt(st.nextToken()); // Starting node

//         graph = new ArrayList[N + 1];
//         for (int i = 1; i <= N; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         for (int i = 0; i < M; i++) {
//             st = new StringTokenizer(br.readLine(), " ");
//             int a = Integer.parseInt(st.nextToken());
//             int b = Integer.parseInt(st.nextToken());
//             graph[a].add(b);
//             graph[b].add(a);
//         }

//         for (int i = 1; i <= N; i++) {
//             Collections.sort(graph[i]); // Sort for lexicographical order
//         }

//         visited = new boolean[N + 1];
//         dfs(V);
//         System.out.println();

//         visited = new boolean[N + 1];
//         bfs(V);
//         System.out.println();
//     }

//     public static void dfs(int node) {
//         visited[node] = true;
//         System.out.print(node + " ");
//         for (int next : graph[node]) {
//             if (!visited[next]) {
//                 dfs(next);
//             }
//         }
//     }

//     public static void bfs(int start) {
//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(start);
//         visited[start] = true;
//         while (!queue.isEmpty()) {
//             int node = queue.poll();
//             System.out.print(node + " ");
//             for (int next : graph[node]) {
//                 if (!visited[next]) {
//                     queue.add(next);
//                     visited[next] = true;
//                 }
//             }
//         }
//     }
// }
