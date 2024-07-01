package Java_05_hw;

import java.util.*;
import java.io.*;

public class baekjoon_1916_최지우 {
    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static int n, m;
    static List<List<Node>> link;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        link = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            link.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            link.get(s).add(new Node(e, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] d = new int[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        que.add(new Node(start, 0));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int now = cur.end;
            int now_cost = cur.cost;

            if (d[now] < now_cost) {
                continue;
            }

            for (Node nxt: link.get(now)) {
                int new_cost = now_cost + nxt.cost;
                if (new_cost < d[nxt.end]) {
                    d[nxt.end] = new_cost;
                    que.add(new Node(nxt.end, new_cost));
                }
            }
        }

        System.out.println(d[target]);
    }
}