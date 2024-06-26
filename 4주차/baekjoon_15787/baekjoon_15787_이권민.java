package 4주차.baekjoon_15787;

import java.io.*;
import java.util.*;
public class baekjoon_15787_이권민 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken()); 
    
            int[] trains = new int[N + 1]; // 열차개수
            boolean[] seen = new boolean[(1 << 20) + 1]; // 열차 중복체크용
    
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int command = Integer.parseInt(st.nextToken());
                int trainIndex = Integer.parseInt(st.nextToken());
    
                if (command == 1) {
                    int seat = Integer.parseInt(st.nextToken());
                    trains[trainIndex] |= (1 << (seat - 1)); // Set the seat
                } else if (command == 2) {
                    int seat = Integer.parseInt(st.nextToken());
                    trains[trainIndex] &= ~(1 << (seat - 1)); // Clear the seat
                } else if (command == 3) {
                    trains[trainIndex] <<= 1; // Shift left
                    trains[trainIndex] &= (1 << 20) - 1; // Mask to keep only the last 20 bits
                } else if (command == 4) {
                    trains[trainIndex] >>= 1; // Shift right
                }
            }
    
            int uniqueCount = 0;
            for (int i = 1; i <= N; i++) {
                if (!seen[trains[i]]) {
                    seen[trains[i]] = true;
                    uniqueCount++;
                }
            }
    
            System.out.println(uniqueCount);
        }
    }


    
    // package baekjoon_15787;

    // import java.io.*;
    // import java.util.*;
    
    // public class baekjoon_15787 {
    //     public static void main(String[] args) throws IOException {
    //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    //         int N = Integer.parseInt(st.nextToken()); // Number of trains
    //         int M = Integer.parseInt(st.nextToken()); // Number of commands
    
    //         int[] trains = new int[N + 1]; // Train states
    
    //         for (int i = 0; i < M; i++) {
    //             st = new StringTokenizer(br.readLine(), " ");
    //             int command = Integer.parseInt(st.nextToken());
    //             int trainIndex = Integer.parseInt(st.nextToken());
    
    //             if (command == 1) {
    //                 int seat = Integer.parseInt(st.nextToken());
    //                 trains[trainIndex] |= (1 << (seat - 1)); // Set the seat
    //             } else if (command == 2) {
    //                 int seat = Integer.parseInt(st.nextToken());
    //                 trains[trainIndex] &= ~(1 << (seat - 1)); // Clear the seat
    //             } else if (command == 3) {
    //                 trains[trainIndex] <<= 1; // Shift left
    //                 trains[trainIndex] &= (1 << 20) - 1; // Mask to keep only the last 20 bits
    //             } else if (command == 4) {
    //                 trains[trainIndex] >>= 1; // Shift right
    //             }
    //         }
    
    //         Set<Integer> uniqueTrains = new HashSet<>();
    //         for (int i = 1; i <= N; i++) {
    //             uniqueTrains.add(trains[i]);
    //         }
    
    //         System.out.println(uniqueTrains.size());
    //     }
    // }
    
