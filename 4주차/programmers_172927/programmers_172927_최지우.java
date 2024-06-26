import java.io.*;
import java.util.*;

public class programmers_172927_최지우 {
    private static final int[] p = new int[]{1, 3, 2};
    private static final String[] m = new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

    public static void main(String[] args) throws IOException {
        System.out.println(solution(p, m));
    }
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int groupSize = minerals.length;
        int maxMine = Arrays.stream(picks).sum() * 5;
        int[][] group = new int[maxMine/5+1][5];
        int cost = 1;
        for (int i = 0; i < groupSize; i++) {
            if (i >= maxMine) break;
            int groupNum = i/5;
            int mineIdx = i%5;

            for (int j = 0; j < 5; j++) {
                if (minerals[i].equals("diamond")) {
                    cost = 25;
                } else if (minerals[i].equals("iron")) {
                    cost = 5;
                } else {
                    cost = 1;
                }
                group[groupNum][mineIdx] = cost;
            }
        }

        Comparator<int[]> sumCom = (a, b) -> {
            int sumA = Arrays.stream(a).sum();
            int sumB = Arrays.stream(b).sum();
            return Integer.compare(sumB, sumA);
        };

        Arrays.sort(group, sumCom);

        for (int i = 0; i < groupSize/5+1; i++) {
            int k = 0;
            if (picks[0] > 0) {
                k = 25;
                picks[0] -= 1;
            } else if (picks[1] > 0) {
                k = 5;
                picks[1] -= 1;
            } else if (picks[2] > 0) {
                k = 1;
                picks[2] -= 1;
            }
            if (k == 0) break;
            for (int j = 0; j < 5; j++) {
                if (group[i][j] == 0) break;

                if (group[i][j] / k == 0) {
                    answer += 1;
                } else {
                    answer += group[i][j] / k;
                }
            }
        }
        return answer;
    }
}


