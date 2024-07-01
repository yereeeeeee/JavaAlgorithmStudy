import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null) {
            String[] chars = line.split("");
            int count = 0;
            int sum = 0;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i].compareTo(chars[i-1]) == 0) {
                    if (chars[i].compareTo("(") == 0)
                        count++;
                    else
                        sum += count;
                }
            }
            bw.write(sum + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
