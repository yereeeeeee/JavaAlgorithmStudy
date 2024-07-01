package Algorithm5;

import java.util.Scanner;

public class baekjoon_17413_정훈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        System.out.println(reverse(S));
        sc.close();
    }

    public static String reverse(String S) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = S.length();
        
        while (i < n) {
            if (S.charAt(i) == '<') {
                int j = i;
                while (j < n && S.charAt(j) != '>') {
                    j++;
                }
                j++;
                result.append(S.substring(i, j));
                i = j;
            } else if (Character.isLetterOrDigit(S.charAt(i))) {
                int j = i;
                while (j < n && Character.isLetterOrDigit(S.charAt(j))) {
                    j++;
                }
                result.append(new StringBuilder(S.substring(i, j)).reverse());
                i = j;
            } else {
                result.append(S.charAt(i));
                i++;
            }
        }
        
        return result.toString();
    }
}

