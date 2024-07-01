import java.io.*;
import java.util.*;
package 5주차;

public class baekjoon_9020_이권민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] result = findGoldbachPartition(n);
            System.out.println(result[0] + " " + result[1]);
        }

        br.close();
    }

    // 골드바흐 파티션을 찾는 메서드
    public static int[] findGoldbachPartition(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        // 에라토스테네스의 체를 사용하여 소수 판별
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        // 모든 원소를 소수로 가정. true로 초기화. 0과 1은 소수가 아님을 명시적으로 처리
        // 각 소수의 배수를 소수가 아닌 것으로 표시, 루트 n 까지.
        // n/2부터 차례대로 소수인지 검사하여 골드바흐 파티션을 찾음
        for (int i = n / 2; i >= 2; i--) {
            if (isPrime[i] && isPrime[n - i]) {
                return new int[] { i, n - i };
            }
        }

        return new int[2]; // 예외 처리 - 문제의 조건에서는 항상 답이 존재한다고 가정
    }
}
