package Java_05_hw;

import java.util.*;
import java.io.*;

public class baekjoon_17413_최지우 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String S = br.readLine();

        boolean tag = false;
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '<') {
                tag = true;
                queue.add('<');
                continue;
            }

            if (S.charAt(i) == '>') {
                tag = false;
                queue.add('>');
                stackFlush(stack, 0);
                queueFlush(queue);
                continue;
            }

            if (tag) {
                queue.add(S.charAt(i));
                continue;
            }

            if (S.charAt(i) == ' ') {
                stackFlush(stack, 1);
                continue;
            }

            stack.push(S.charAt(i));
        }

        stackFlush(stack, 0);

        bw.flush();
        bw.close();
        br.close();
    }
    private static void stackFlush(Stack<Character> stack, int c) throws IOException{
        while (!stack.isEmpty()) bw.append(stack.pop());
        if (c == 1) bw.append(' ');
    }
    private static void queueFlush(Queue<Character> queue) throws IOException{
        while (!queue.isEmpty()) bw.append(queue.poll());
    }
}
