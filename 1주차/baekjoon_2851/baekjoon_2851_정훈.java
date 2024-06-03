package Algorithm1;

import java.util.Scanner;

public class baekjoon_2851_정훈 {
	public static void main(String[] args) {
        int[] arr = new int[10];  // 크기가 10인 정수 배열을 선언합니다.
        Scanner sc = new Scanner(System.in);  // Scanner 객체를 생성하여 입력을 받기 위해 준비합니다.
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();  // 10개의 정수를 입력 받아 배열에 저장합니다.
        }
        int answer = arr[0];  // 초기값을 배열의 첫 번째 값으로 설정합니다.
        for (int i = 1; i < 10; i++) {
            // 현재까지의 합이 100에 가까운지 확인합니다.
            if (Math.abs(100 - (arr[i] + arr[i - 1])) < Math.abs(100 - arr[i])) {
                arr[i] = arr[i] + arr[i - 1];  // 현재 값에 이전 값을 더해서 갱신합니다.
                // 갱신된 값이 100에 더 가까운지 확인합니다.
                if (Math.abs(100 - arr[i]) <= Math.abs(100 - answer)) {
                    answer = arr[i];  // 더 가까운 값으로 정답을 갱신합니다.
                }
            }
        }
        System.out.println(answer);  // 최종 결과를 출력합니다.
    }
}


