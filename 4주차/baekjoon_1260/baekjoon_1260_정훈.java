package Algorithm4;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class baekjoon_1260_정훈 {
	static int N, M, V;
	static int [][] graph;
	static boolean[] visited1;
	static boolean[] visited2;
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        // 행렬 만들기
        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }

        // 방문 리스트 행렬
        visited1 = new boolean[N + 1];
        visited2 = new boolean[N + 1];

        // DFS 호출
        dfs(V);
        System.out.println();

        // BFS 호출
        bfs(V);
    }

    // DFS 함수 만들기
    public static void dfs(int V) {
        visited1[V] = true; // 방문처리
        System.out.print(V + " ");
        for (int i = 1; i <= N; i++) {
            if (graph[V][i] == 1 && !visited1[i]) {
                dfs(i);
            }
        }
    }

    // BFS 함수 만들기
    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited2[V] = true; // 방문처리
        while (!queue.isEmpty()) {
            V = queue.poll(); // 방문 노드 제거
            System.out.print(V + " ");
            for (int i = 1; i <= N; i++) {
                if (!visited2[i] && graph[V][i] == 1) {
                    queue.add(i);
                    visited2[i] = true; // 방문처리
                }
            }
        }
    }
}

