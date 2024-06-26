import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] picks = new int[3];
        for (int i = 0; i < 3; i++) {
            picks[i] = Integer.parseInt(st.nextToken());
        }

        String[] minerals = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            minerals[i] = st.nextToken();
        }

//        System.out.println(Arrays.toString(picks));
//        System.out.println(Arrays.toString(minerals));

        int result = solution(picks, minerals);
        System.out.println(result);

    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[] sum = new int[picks[0] + picks[1] + picks[2]];

        for (int i = 0; i < minerals.length; i++) {
            if (i / 5 >= sum.length) {
                break;
            }
            if (minerals[i].equals("diamond")) {
                sum[i / 5] += 100;
            } else if (minerals[i].equals("iron")) {
                sum[i / 5] += 10;
            } else {
                sum[i / 5] += 1;
            }
        }

        Arrays.sort(sum);
        System.out.println(Arrays.toString(sum));
        int i = sum.length - 1;

        while (i >= 0 && sum[i] > 0) {
            if (picks[0] > 0) {
                answer += sum[i] / 100;
                sum[i] %= 100;
                answer += sum[i] / 10;
                sum[i] %= 10;
                answer += sum[i];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += sum[i] / 100 * 5;
                sum[i] %= 100;
                answer += sum[i] / 10;
                sum[i] %= 10;
                answer += sum[i];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += sum[i] / 100 * 25;
                sum[i] %= 100;
                answer += sum[i] / 10 * 5;
                sum[i] %= 10;
                answer += sum[i];
                picks[2]--;
            } else {
                return answer;
            }
            i--;
        }
        return answer;

    }

}

/*
8
1 3 2
diamond diamond diamond iron iron diamond iron stone

11
0 1 1
diamond diamond diamond diamond diamond iron iron iron iron iron diamond
 */