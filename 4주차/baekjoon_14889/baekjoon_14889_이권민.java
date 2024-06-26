

package 4주차.baekjoon_14889;

import java.io.*;
import java.util.*;

public class baekjoon_14889_이권민 {
    static int[][] graph;
    static int N;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 조합을 이용하여 팀을 나누고 최솟값 계산
        boolean[] visited = new boolean[N + 1];
        divideTeams(1, 0, visited);

        System.out.println(minDiff);
    }

    // 조합을 이용하여 팀을 나누고 각 팀의 능력치 차이를 계산하는 함수
    static void divideTeams(int index, int count, boolean[] visited) {
        if (count == N / 2) {
            calculateDifference(visited);
            return;
        }

        for (int i = index; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                divideTeams(i + 1, count + 1, visited);
                visited[i] = false;
            }
        }
    }

    // 각 팀의 능력치 차이를 계산하고 최솟값 갱신하는 함수
    static void calculateDifference(boolean[] visited) {
        ArrayList<Integer> teamStart = new ArrayList<>();
        ArrayList<Integer> teamLink = new ArrayList<>();

        // 각 팀에 속하는 사람들을 구분
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                teamStart.add(i);
            } else {
                teamLink.add(i);
            }
        }

        // 각 팀의 능력치 합 계산
        int sumStart = 0;
        int sumLink = 0;

        for (int i = 0; i < teamStart.size(); i++) {
            for (int j = i + 1; j < teamStart.size(); j++) {
                int member1 = teamStart.get(i);
                int member2 = teamStart.get(j);
                sumStart += graph[member1][member2] + graph[member2][member1]; // 양방향
            }
        }

        for (int i = 0; i < teamLink.size(); i++) {
            for (int j = i + 1; j < teamLink.size(); j++) {
                int member1 = teamLink.get(i);
                int member2 = teamLink.get(j);
                sumLink += graph[member1][member2] + graph[member2][member1]; // 양방향
            }
        }

        // 능력치 차이의 절대값 계산
        int diff = Math.abs(sumStart - sumLink);
        // 최솟값 갱신
        minDiff = Math.min(minDiff, diff);
    }
}

