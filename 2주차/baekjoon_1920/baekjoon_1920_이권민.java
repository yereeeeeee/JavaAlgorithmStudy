import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 정수형 우선순위 큐 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        // 배열 크기 설정
        st = new StringTokenizer (br.readLine()," ");

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer (br.readLine()," ");

        while (M --> 0) {
            int n = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(array, n) >= 0) { // 요소가 존재할 때
                sb.append(1).append('\n');
            } else { // 요소가 존재하지 않을 때
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
        }
    }

