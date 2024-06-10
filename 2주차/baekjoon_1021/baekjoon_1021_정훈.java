package Algorithm2;

import java.util.*;

public class baekjoon_1021_정훈 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 큐의 크기
        int M = scanner.nextInt(); // 뽑아 내려고 하는 

        Deque<Integer> deque = new ArrayDeque<>(); // 큐 구현하기
        
        int count = 0; // 이동횟수

        for (int i = 1; i <= N; i++) // 큐에 1부터 N 까지 넣기
            deque.add(i);

        for (int i = 0; i < M; i++) { // 뽑아 내기 시작 
            int target = scanner.nextInt(); // 여기서 부터 하나씩 처리한데이
            int leftDistance = 0;

            while (deque.peekFirst() != target) { // 입력 받은 타겟이 제일 앞에 올때까지
                deque.addLast(deque.pollFirst()); // 큐의 제일 앞에 있는걸 제일 뒤로 이
                leftDistance++; // 이동횟수 증가 시켜야지
            }

            int rightDistance = deque.size() - leftDistance; // 오른쪽으로 돌리는 건 전체 크기에서 왼쪽 뺀거 

            count += Math.min(leftDistance, rightDistance); // 나는 더 작은걸 쓸거얌
            deque.pollFirst(); // 해당 수를 뽑아 내야쥬
        }

        System.out.println(count);
        scanner.close();
	}

}
