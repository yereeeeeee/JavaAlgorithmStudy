import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

package 5주차;

public class baekjoon11279_이권민 {
    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (maxHeap.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(maxHeap.poll()+"\n");
                }
            } else {
                maxHeap.add(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
    
    
}
