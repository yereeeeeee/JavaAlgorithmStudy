import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter 이렇게 작성하면 Scanner랑 System.out.println 보다 빠름
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[11];
        // 10개 줄의 버섯점수가 나오기 때문에 배열 크기 11로 설정
        //버섯 점수 저장
        for(int i=1;i<=10;i++)
            arr[i] = arr[i-1] + Integer.parseInt(br.readLine());
        int dif = Integer.MAX_VALUE;	//숫자에서 100까지의 거리 최소값
        int answer = 0;
        for(int i=10;i>0;i--){
            int temp = Math.abs(100 - arr[i]);
            if(dif > temp){		//100까지의 거리가 더 작을 때
                dif = temp;		//100까지의 거리 최소값 변경
                answer = arr[i];	//현재값 가장 가까운 값으로 변경
            }
        }
        bw.write(answer + "");	//100에 가장 가까운 값 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}