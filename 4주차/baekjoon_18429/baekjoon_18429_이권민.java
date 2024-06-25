package 4주차.baekjoon_18429;
import java.io.*;
import java.util.*;
public class baekjoon_18429_이권민 {
    static int N, K, answer;
	static int[] array;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new int[N];
		check = new boolean[N];
		answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken()) - K;
		BackTracking(0, 0);
		System.out.println(answer);
	}

	
	private static void BackTracking(int count, int sum) {
		// Basecase
		if(count == N) {
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!check[i] && sum + array[i] >= 0) {
				check[i] = true;
				BackTracking(count + 1, sum + array[i]);
				check[i] = false;
			}
		}
	}
}
