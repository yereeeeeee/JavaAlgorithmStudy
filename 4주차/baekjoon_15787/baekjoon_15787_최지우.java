import java.io.*;
import java.util.*;

public class baekjoon_15787_최지우 {
    private static int n;
    private static int[] trains;
    private static final int max_pos = 20;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trains = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken()) - 1;
            int pos = 0;

            if (cmd == 1 || cmd == 2) {
                pos = Integer.parseInt(st.nextToken()) - 1;
            }
            bitCheck(cmd, train, pos);
        }

        Set<Integer> passCheck = new HashSet<>();
        for (int train: trains) {
            passCheck.add(train);
        }
        System.out.println(passCheck.size());
    }
    private static void bitCheck(int cmd, int train, int pos) {
        switch (cmd) {
            case 1:
                trains[train] |= (1 << pos);
                break;
            case 2:
                trains[train] &= ~(1 << pos);
                break;
            case 3:
                trains[train] <<= 1;
                trains[train] &= (1 << max_pos) -1;
                break;
            case 4:
                trains[train] >>= 1;
                break;
        }
    }
}
