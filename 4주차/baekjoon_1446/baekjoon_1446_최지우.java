import java.util.*;
import java.io.*;

class Shortcut {
    int start, end, length;

    Shortcut(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}

public class baekjoon_1446_최지우 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, d;
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        List<Shortcut> shortcuts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if (end <= d) {
                shortcuts.add(new Shortcut(start, end, length));
            }
        }

        System.out.println(findPath(d, shortcuts));
    }

    private static int findPath(int d, List<Shortcut> shortcuts) {
        int[] dist = new int[d + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i <= d; i++) {
            if (i>0) {
                dist[i] = Math.min(dist[i], dist[i-1] + 1);
            }
            for (Shortcut sc : shortcuts) {
                if (sc.start == i && dist[sc.start] + sc.length < dist[sc.end]) {
                    dist[sc.end] = dist[sc.start] + sc.length;
                }
            }
        }
        return dist[d];
    }
}
