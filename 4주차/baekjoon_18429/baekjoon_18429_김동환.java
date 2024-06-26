// 3대 500의 대학생이 하루가 지날때마다 중량이 K씩 줄어든다.
// 근데 운동 키트를 사용하면 중량이 즉시 증가함 (N일 동안 한번만 쓸수있음)
// 항상 500이상을 유지할 수 있는 경우의 수 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, answer;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        visit=new boolean[n];
        answer=0;
        dfs(500, 0);
        System.out.println(answer);
    }

    public static void dfs(int sum, int cnt){
        if(cnt == n){
            answer++;
            return;
        }
        for(int i=0; i<n; i++){
            if(!visit[i] && sum+arr[i]-k >= 500) {
                visit[i]=true;
                dfs(sum+arr[i]-k, cnt+1);
                visit[i]=false;
            }
        }
    }
}
