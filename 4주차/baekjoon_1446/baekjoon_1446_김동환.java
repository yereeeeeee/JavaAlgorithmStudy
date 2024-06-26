import java.io.*;
import java.util.*;

public class Main {
    static class Info implements Comparable<Info> {
        int node;
        int weight;

        Info(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int N, D;
    static List<List<Info>> graph = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[D + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (end <= D) {
                graph.get(start).add(new Info(end, weight));
            }
        }

        dijkstra();

        bw.write(String.valueOf(distance[D]));
        bw.flush();
        br.close();
        bw.close();
    }

    static void dijkstra() {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, 0));

        while (!pq.isEmpty()) {
            Info current = pq.poll();
            int currentNode = current.node;
            int currentWeight = current.weight;

            if (currentWeight > distance[currentNode]) {
                continue;
            }

            for (Info neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.node;
                int nextWeight = currentWeight + neighbor.weight;

                if (nextWeight < distance[nextNode]) {
                    distance[nextNode] = nextWeight;
                    pq.add(new Info(nextNode, nextWeight));
                }
            }

            if (currentNode + 1 <= D && currentWeight + 1 < distance[currentNode + 1]) {
                distance[currentNode + 1] = currentWeight + 1;
                pq.add(new Info(currentNode + 1, currentWeight + 1));
            }
        }
    }
}
