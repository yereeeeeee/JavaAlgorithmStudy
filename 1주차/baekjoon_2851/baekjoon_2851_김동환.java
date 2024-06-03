import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] mush = new int[10];
		int sum;		
		int result;		
		int eat = 1;	
		int compare1;	
		int compare2;	
		
		for(int i=0; i<mush.length; i++){
			mush[i] = scan.nextInt();
        }
		result = mush[0];
		
		for(int i=0; i<mush.length; i++) {
			sum = 0;
			if(eat == 10) {
				break;
            }
			for(int j=0; j<=eat; j++) {
				sum += mush[j];
                // 점수가 100 => 탈출
                if(sum == 100) {
                    result = sum;
                    break;
                }
            }
			// 버섯의 총 점수가 100보다 큰경우도 있으므로 절댓값으로 판단함
			compare1 = Math.abs(100 - result);
			compare2 = Math.abs(100 - sum);
			
			// 버섯 점수의 총 합이 100에 근사한 값 찾기 
			if(compare1 >= compare2)
				result = sum;
			eat ++;
		}
		
		System.out.println(result);
		scan.close();
	}

}