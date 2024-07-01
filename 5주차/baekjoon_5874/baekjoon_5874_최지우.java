package Java_05_hw;

import java.util.*;
import java.io.*;

public class baekjoon_5874_최지우 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == '(' && str.charAt(i+1) == '(') {
                left.push(i);
            }

            if (i==0) continue;

            if (str.charAt(i) == ')' && str.charAt(i+1) == ')') {
                right.push(i+1);
            }
        }

        while (!right.isEmpty()) {
            int pos = right.pop();
            if (!left.isEmpty()) {
                while (left.peek() >= pos) left.pop();
                cnt += left.size();
            }
        }
        System.out.println(cnt);
    }
}
