package Algorithm3;
import java.util.Scanner;

public class baekjoon_1740_정훈 {
	public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        long n = Long.parseLong(scanner.next());
        long threeNum = 1;
        long ans = 0;
        
        while(n > 0){
            // & 연산이 1인 경우
            if( (n&1) ==1){
                ans += threeNum;
            }
            
            threeNum *= 3; // 거듭제곱하기
            n = n>>1; // 오른쪽 시프트 연산
        }
        
        System.out.println(ans);
        
        
    }
}