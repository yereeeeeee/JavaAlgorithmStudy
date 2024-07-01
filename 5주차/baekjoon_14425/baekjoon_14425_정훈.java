package Algorithm5;

import java.util.HashSet;
import java.util.Scanner;

public class baekjoon_14425_정훈 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); 
        
        HashSet<String> setS = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            setS.add(sc.nextLine());
        }
        
        int count = 0;
        
        for (int i = 0; i < M; i++) {
            String query = sc.nextLine();
            if (setS.contains(query)) {
                count++;
            }
        }
        
        System.out.println(count);
        
        sc.close();
    }
}
