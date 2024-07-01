import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_17413_이권민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        boolean insideTag = false;

        for (char c : input.toCharArray()) {
            if (c == '<') {
                // 태그 시작, 스택에 있는 문자들을 모두 sb에 추가하여 단어를 뒤집는다.
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                insideTag = true;
                sb.append(c);
            } else if (c == '>') {
                insideTag = false;
                sb.append(c);
            } else if (insideTag) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    // 공백 문자를 만나면 스택에 있는 문자들을 모두 sb에 추가하여 단어를 뒤집는다.
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    // 태그 밖의 문자는 스택에 넣는다.
                    stack.add(c);
                }
            }
        }

        // 마지막으로 남아 있는 스택을 비운다.
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
