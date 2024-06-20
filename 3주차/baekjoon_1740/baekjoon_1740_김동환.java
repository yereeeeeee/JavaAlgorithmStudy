import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        long N = Long.parseLong(br.readLine());
        long result = 0;
        long cnt = 1;

        while (N > 0) {
            if ((N&1) == 1) {
                result += cnt;
            }

            cnt *= 3;
            N = N>>1;
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();

    }
}