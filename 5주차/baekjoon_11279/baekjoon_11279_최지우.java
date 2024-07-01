package Java_05_hw;

import java.util.*;
import java.io.*;

public class baekjoon_11279_최지우 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            if (x > 0) {
                heap.add(x);
            } else {
                if (!heap.isEmpty()) {
                    bw.write(heap.poll().toString() + "\n");
                } else bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}