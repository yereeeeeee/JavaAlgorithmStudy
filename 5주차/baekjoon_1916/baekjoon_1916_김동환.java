import java.util.*;
import java.io.*;

class Bus implements Comparable<Bus> {
    int arrive, weight;

    Bus(int arrive, int weight) {
        this.arrive = arrive;
        this.weight = weight;
    }

    @Override
    public int compareTo(Bus b) {
        return this.weight - b.weight;
    }
}

public class Main {
    static int N, M;
    static ArrayList<Bus>[] busMap;
    static boolean[] visit;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        busMap = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            busMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            busMap[start].add(new Bus(end, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        dijkstra(startCity);
        bw.write(dist[endCity] + "");
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int startCity) {
        PriorityQueue<Bus> queue = new PriorityQueue<>();
        queue.offer(new Bus(startCity, 0));
        dist[startCity] = 0;

        while (!queue.isEmpty()) {
            Bus currBus = queue.poll();
            int currEnd = currBus.arrive;

            if (!visit[currEnd]) {
                visit[currEnd] = true;

                for (Bus b : busMap[currEnd]) {
                    if (!visit[b.arrive] && dist[b.arrive] > dist[currEnd] + b.weight) {
                        dist[b.arrive] = dist[currEnd] + b.weight;
                        queue.offer(new Bus(b.arrive, dist[b.arrive]));
                    }
                }
            }
        }
    }
}
