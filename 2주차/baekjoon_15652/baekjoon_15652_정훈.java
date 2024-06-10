package Algorithm2;

import java.util.Scanner;

public class baekjoon_15652_정훈 {
    static int N, M; // 전역 변수로 사용할거라 여기서 먼저 시작하고 갑니데이
    static int[] selected; // 수열을 저장은 해야죠
    static StringBuilder sb = new StringBuilder(); // 결과 값은 저장해야죠

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt(); // N개 자연수
        M = scanner.nextInt(); // M개 뽑기

        selected = new int[M]; // 선택한 수열을 저장할건데 하나 넣고 나면 초기화 해야지

        backtracking(1, 0); // 백트래킹함수를 불러옵니데이

        System.out.println(sb.toString()); // 결과를 출력 합니데이

        scanner.close();
    }

    static void backtracking(int start, int depth) {
        if (depth == M) { // 수열의 길이가 M이 되면
            for (int num : selected) { // 선택한 수열을 StringBuilder에 저장을 합니데이
                sb.append(num).append(" ");
            }
            sb.append("\n"); // 출력은 줄바꿈해서 하니까ㅎ
            return;
        }

        for (int i = start; i <= N; i++) { // 현재 위치부터 N까지 반복
            selected[depth] = i; // 선택한 수열에 지금 숫자 추가
            backtracking(i, depth + 1); // 재귀 호출
        }
    }
}
