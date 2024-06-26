package Algorithm4;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class baekjoon_15787_정훈 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] trains = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int command = sc.nextInt();
            int trainIndex = sc.nextInt();

            if (command == 1) {
                int seatIndex = sc.nextInt();
                trains[trainIndex] |= (1 << (seatIndex - 1));
            } else if (command == 2) {
                int seatIndex = sc.nextInt();
                trains[trainIndex] &= ~(1 << (seatIndex - 1));
            } else if (command == 3) {
                trains[trainIndex] <<= 1;
                trains[trainIndex] &= (1 << 20) - 1;  // Keep only the lower 20 bits
            } else if (command == 4) {
                trains[trainIndex] >>= 1;
            }
        }

        Set<Integer> uniqueTrains = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            uniqueTrains.add(trains[i]);
        }

        System.out.println(uniqueTrains.size());
    }
}
