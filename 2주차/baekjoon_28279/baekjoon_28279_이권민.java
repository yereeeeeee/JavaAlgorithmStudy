
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Deque;
// import java.util.LinkedList;
// import java.util.StringTokenizer;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 입력을 버퍼링해서 읽기때문에 효율적, readline 사용_편리
//         Deque<Integer> dq = new LinkedList<>();
// 노드가 양방향 링크, 양끝에서 삽입과 삭제가 O(1), 크기가 가변적
// 노드가 추가적인 메모리 사용, 임의요소 접근 시 O(n)
//         int N = Integer.parseInt(br.readLine());
//         StringTokenizer st;
// query
//         StringBuilder sb = new StringBuilder();
//  출력용

//         for(int i = 0; i < N; i++) {
//             st = new StringTokenizer(br.readLine());
//             switch(st.nextToken()) {
//                 case "1" : dq.addFirst(Integer.parseInt(st.nextToken())); break;
//                 case "2" : dq.addLast(Integer.parseInt(st.nextToken())); break;
//                 case "3" : sb.append(!dq.isEmpty() ? dq.removeFirst() : -1).append("\n"); break;
//                 case "4" : sb.append(!dq.isEmpty() ? dq.removeLast() : -1).append("\n"); break;
//                 case "5" : sb.append(dq.size()).append("\n"); break;
//                 case "6" : sb.append(dq.isEmpty() ? 1 : 0).append("\n"); break;
//                 case "7" : sb.append(!dq.isEmpty() ? dq.getFirst() : -1).append("\n"); break;
//                 case "8" : sb.append(!dq.isEmpty() ? dq.getLast() : -1).append("\n"); break;
//  삼항연산자, break로 다음 블록으로 넘어가는 거 막음
//             }

//         }
//         System.out.println(sb.toString());
//     }

// }

import java.io.*;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deque = new ArrayDeque<>();
// 추가적인 노드 x, 임의접근 효율적. 크기제한, 크기변경 비용
// <>는 제네릭타입 추론. 
// ConcurrentLinkedDeque, LinkedBlockingDeque
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //명령어의 수

        while(N --> 0) {
            // 반복문 실행될때마다 하나씩 줄어듬. 0보다 크거나 같은 경우에만 실행. 
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            switch (order){
                case 1 : //명령어 1 X : 덱의 앞에 넣는다
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2 : //명령어 2 X : 덱의 뒤에 넣는다
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3 : //명령어 3 : 덱의 맨 앞의 정수를 빼서 출력한다.(없다면 -1)
                    sb.append(deque.isEmpty()? -1 : deque.pollFirst()).append("\n");
                    break;
                    // removeFirst는 덱이 비어있지 않은 경우에만 사용가능. pollFirst는 비어있으면 null
                case 4 : //명령어 4 : 덱의 맨 뒤의 정수를 빼서 출력한다.(없다면 -1)
                    sb.append(deque.isEmpty()? -1 : deque.pollLast()).append("\n");
                    break;
                case 5 : //명령어 5 : 덱에 들어있는 정수의 개수 출력
                    sb.append(deque.size()).append("\n");
                    break;
                case 6 : //명령어 6 : 덱이 비어있으면 1 출력 비어있지 않으면 0
                    sb.append(deque.isEmpty()? 1 : 0).append("\n");
                    break;
                case 7 : //명령어 7 : 덱에 정수가 있다면 맨 앞의 정수를 출력(없다면 -1)
                    sb.append(deque.isEmpty()? -1 :deque.peekFirst()).append("\n");
                    break;
                case 8 : //명령어 8 : 덱에 정수가 있다면 맨 뒤의 정수를 출력(없다면 -1)
                    sb.append(deque.isEmpty()? -1 : deque.peekLast()).append("\n");
                    break;
            }
        }
        br.close();
        System.out.println(sb);
    }

}