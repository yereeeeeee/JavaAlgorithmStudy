package Algorithm4;

import java.util.*;

public class baekjooon_18429_정훈 {

    static int N, K;
    static int[] A;
    static int count = 0;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        A = new int[N];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        backtrack(0, 500);

        System.out.println(count);
    }

    static void backtrack(int day, int currentWeight) {
        if (day == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                int nextWeight = currentWeight + A[i] - K;
                if (nextWeight >= 500) {
                    used[i] = true;
                    backtrack(day + 1, nextWeight);
                    used[i] = false;
                }
            }
        }
    }
}

