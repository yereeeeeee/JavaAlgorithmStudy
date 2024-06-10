package Algorithm2;

import java.util.*;

public class baekjoon_1920_정훈 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 배열의 크기 
        int[] array = new int[N]; // 배열 만들기 
        for (int i = 0; i < N; i++) { // 배열에 숫자 넣기
            array[i] = scanner.nextInt(); 
        }

        // 배열 정렬
        Arrays.sort(array);

        int M = scanner.nextInt(); // 찾으려는 숫자 갯수 입력 받기 
        int[] targets = new int[M]; // 배열 만들기
        for (int i = 0; i < M; i++) { // 숫자 넣기
            targets[i] = scanner.nextInt();
        }

        // 각 숫자에 대해 이진 탐색 수행하여 결과 출력
        for (int i = 0; i < M; i++) {
            if (binarySearch(array, targets[i])) {
                System.out.println(1); // 존재하면 1 출력
            } else {
                System.out.println(0); // 존재하지 않으면 0 출력
            }
        }

        scanner.close();
    }

    // 이진 탐색
    public static boolean binarySearch(int[] array, int target) {
        int left = 0; // 시작 인덱스 초기화
        int right = array.length - 1; // 끝 인덱스 초기화

        while (left <= right) { // 시작이 끝과 같거나 작을 때 까지 실행
            int mid = (left + right) / 2; // 중간값 계산
            if (array[mid] == target) { // 중간값이 타겟이랑 같으면 트루ㅜㅜㅜ 
                return true;
            } else if (array[mid] < target) { // 중간 값이 타겟보다 작으면 오른쪽으로 가야죠 
                left = mid + 1;
            } else { // 중간 값이 타겟보다 크면 왼쪽으로 가야쥬
                right = mid - 1;
            }
        }

        return false;
	}
}
