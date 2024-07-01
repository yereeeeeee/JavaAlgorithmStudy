package Algorithm5;

import java.util.*;

public class baekjoon_1916_정훈 {
    static class Node implements Comparable<Node> {
        int vertex;
        int cost;
        
        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(u).add(new Node(v, cost));
        }
        
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        System.out.println(dijkstra(graph, N, start, end));
        sc.close();
    }
    
    public static int dijkstra(List<List<Node>> graph, int N, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            int currentCost = current.cost;
            
            if (currentCost > dist[currentVertex]) continue;
            
            for (Node neighbor : graph.get(currentVertex)) {
                int newCost = dist[currentVertex] + neighbor.cost;
                
                if (newCost < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newCost;
                    pq.add(new Node(neighbor.vertex, newCost));
                }
            }
        }
        
        return dist[end];
    }
}

