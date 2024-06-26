import java.io.*;
import java.util.*;

public class baekjoon_14889_최지우 {
    static int n;
    static int[][] arr;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> team = new ArrayList<>();

        findMinDiff(0, team);
        System.out.println(result);
        br.close();
    }
    private static void findMinDiff(int idx, List<Integer> team) {
        if (team.size() == n/2) {
            calculate(team);
            return;
        }

        for (int i = idx; i < n; i++) {
            team.add(i);
            findMinDiff(i+1, team);
            team.remove(team.size() - 1);
        }
    }
    private static void calculate(List<Integer> startTeam) {
        boolean[] isStart = new boolean[n];
        for (int member: startTeam) {
            isStart[member] = true;
        }
        List<Integer> linkTeam = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isStart[i]) {
                linkTeam.add(i);
            }
        }
        int sScore = 0, lScore = 0;
        for (int i = 0; i < startTeam.size(); i++) {
            for (int j = i + 1; j < startTeam.size(); j++) {
                int sMember1 = startTeam.get(i);
                int sMember2 = startTeam.get(j);
                sScore += arr[sMember1][sMember2] + arr[sMember2][sMember1];

                int lMember1 = linkTeam.get(i);
                int lMember2 = linkTeam.get(j);
                lScore += arr[lMember1][lMember2] + arr[lMember2][lMember1];
            }
        }

        int diff = Math.abs(sScore - lScore);
        if (diff < result) {
            result = diff;
        }
    }
}
