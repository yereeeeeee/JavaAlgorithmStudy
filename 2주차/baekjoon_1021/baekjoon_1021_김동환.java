// 덱을 만들어야 할 것 같은데
// 자바로 덱을 어떻게 만들까 => linkedlist 로 만든대

import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> deque = new LinkedList<Integer>();
        
        int cnt = 0;

        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] seq = new int[M];

        for(int i =0; i < M; i++) {
            seq[i] = sc.nextInt();
        }

        for(int i=0; i<M; i++) {
            // 인덱스 찾기
            int target_idx = deque.indexOf(seq[i]);
            int mid_idx;
            // 현재 원소가 짝수면 => 절반 -1
            // 아니면 그냥
            if(deque.size() % 2 == 0) {
                mid_idx = deque.size() / 2 - 1;
            } else {
                mid_idx = deque.size() / 2;
            }

            // 이렇게 찾앗음
            if (target_idx <= mid_idx) {
                // idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다.
                for (int j = 0; j < target_idx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    cnt++;
                }
            } else {
                for(int j = 0; j< deque.size() - target_idx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    cnt++;
                }
            }
            deque.pollFirst(); // 이러고 맨앞에꺼 없애줘야함

        }

        System.out.println(cnt);

    }
}