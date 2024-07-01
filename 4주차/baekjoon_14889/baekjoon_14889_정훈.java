package Algorithm4;

import java.util.Scanner;

public class baekjoon_14889_정훈 {
	static int N;
    static int[][] S;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        // 가능한 팀 조합을 백트래킹으로 찾기
        boolean[] team = new boolean[N];
        findMinDifference(team, 0, 0);

        System.out.println(minDifference);
    }

    static void findMinDifference(boolean[] team, int idx, int count) {
        if (count == N / 2) {
            calculateDifference(team);
            return;
        }

        if (idx >= N) return;

        // idx번째 사람을 스타트 팀에 넣음
        team[idx] = true;
        findMinDifference(team, idx + 1, count + 1);

        // idx번째 사람을 스타트 팀에 넣지 않음
        team[idx] = false;
        findMinDifference(team, idx + 1, count);
    }

    static void calculateDifference(boolean[] team) {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (team[i] && team[j]) {
                    startTeamScore += S[i][j] + S[j][i];
                } else if (!team[i] && !team[j]) {
                    linkTeamScore += S[i][j] + S[j][i];
                }
            }
        }

        int difference = Math.abs(startTeamScore - linkTeamScore);
        minDifference = Math.min(minDifference, difference);
    }
}



