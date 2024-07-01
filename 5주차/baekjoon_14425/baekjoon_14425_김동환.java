import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> arr = new HashSet<>();

        for(int i=0; i<N; i++) {
            arr.add(br.readLine());
        }
        int result = 0;
        for (int i=0; i<M; i++) {
            String word = br.readLine();
            if(arr.contains(word)) {
                result++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
