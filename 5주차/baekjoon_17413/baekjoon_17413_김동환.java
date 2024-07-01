import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sentence = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);

            if (c == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
                sb.append(c);
            } else if (c == '>') {
                flag = false;
                sb.append(c);
            } else if (flag) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}
