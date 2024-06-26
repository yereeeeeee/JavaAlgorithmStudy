package 4주차.baekjoon_1446;

import java.io.*;
import java.util.*;

public class baekjoon_1446_이권민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        // 딕셔너리 같은거. 인덱스가 지름길 시작점, 값은 (지름길 도착점, 지름길 길이) 쌍의 리스트
        HashMap<Integer, ArrayList<int[]>> shortcuts = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            
            if (end > D) continue; // 도착점이 목적지 D를 넘는 경우 무시
            
            // 지름길 저장
            shortcuts.putIfAbsent(start, new ArrayList<>());
            shortcuts.get(start).add(new int[]{end, len});
        }
        
        // 거리 배열 초기화
        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        // 동적 계획법으로 최단 거리 계산
        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1); // 1만큼 이동
            }
            
            if (shortcuts.containsKey(i)) {
                for (int[] shortcut : shortcuts.get(i)) {
                    // 지름길 리스트에서 각각의 지름길에 대해 반복. shortcut 변수는 현재 반복 중인 지름길.
                    int end = shortcut[0];
                    int len = shortcut[1];
                    dp[end] = Math.min(dp[end], dp[i] + len); // 지름길 사용
                }
            }
        }
        
        System.out.println(dp[D]);
    }
}
