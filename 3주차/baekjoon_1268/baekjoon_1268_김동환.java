import java.io.*;
import java.util.*;

//오민식은 임시반장을 고르는데, 한번도 같은 반이었던 사람이 가장 많은 학생을 반장으로 뽑으려 함
//그럼 그냥 다 배열을 돌면서 각각 누가 제일 많은 같은 반이였던 사람이 있는지만 확인하면 된다. 

public class Main{  
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int total = Integer.parseInt(br.readLine()); // 학생수
         //  학년별 몇반이였는지 배열 (5학년까지 있으니까 5개) 입력받아줌
        int[][] arr = new int[total][5];
        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max_v = Integer.MIN_VALUE;
        int ans = 0;
        for (int i=0; i<total; i++) {
            int result = 0;
            for (int j=0; j<total; j++) {
                if (i == j) continue; // 자기자신 제외
                else {
                    for (int k=0; k<5; k++) {
                        if (arr[i][k] == arr[j][k]) {
                           result++;
                            break;
                        }
                    }
                }
            }
            if (result > max_v) {
                max_v = result;
                ans = i+1;
            }
        }
        bw.write(String.valueOf(ans));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}