import java.io.*;
import java.util.*;

package 5주차;

public class baekjoon_1916_이권민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 인접 리스트
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new int[] { to, weight });
        }

        // 출발지와 목적지 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라 알고리즘을 사용하여 최단 경로를 찾습니다.
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        // 두번째 요소에 따라 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentWeight = current[1];

            if (currentWeight > dist[currentNode]) {
                continue;
            }

            for (int[] edge : graph[currentNode]) {
                int nextNode = edge[0];
                int newWeight = currentWeight + edge[1];

                if (newWeight < dist[nextNode]) {
                    dist[nextNode] = newWeight;
                    pq.add(new int[] { nextNode, newWeight });
                }
            }
        }

        // 결과 출력
        System.out.println(dist[end]);
        br.close();
    }
}