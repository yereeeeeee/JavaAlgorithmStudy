package Algorithm3;
import java.util.*;

public class baekjoon_1268_정훈 {
	public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] student_classes = new int[num][5];
        for(int i = 0; i < num; i++){
            for(int j = 0; j <5 ; j++){
                student_classes[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        int leader = 0;
        for(int i = 0; i<num; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j<5; j++){
                for(int k = 0; k<num; k++){
                    if(student_classes[i][j] == student_classes[k][j]
                            && i!=k){
                        set.add(k);
                    }
                }
            }
            if(set.size()>max) {
                leader = i;
                max = set.size();
            }
        }
        System.out.println(leader + 1);
        sc.close();
	}
}
