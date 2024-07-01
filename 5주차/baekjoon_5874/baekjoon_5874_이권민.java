import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

package 5주차;

public class baekjoon_5874_이권민 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ch = br.readLine();
        // ((가 나오면 left += 1. right는 나올때마다 result += left
        int left_cnt = 0;
        int left = 0;
        int right = 0;
        int result = 0;
        for (char c : ch.toCharArray()) {
            if (c == '(') {
                left += 1;
                right = 0;
            } else {
                right += 1;
                left = 0;
            }

            if (left == 2) {
                left_cnt += 1;
                left = 1;
            }
            if (right == 2) {
                result += left_cnt;
                right = 1;
            }

        }
        System.out.println(result);
        br.close();
        
    }
    
}
