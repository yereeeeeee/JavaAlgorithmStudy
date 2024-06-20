// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         long N = Long.parseLong(br.readLine());
        
//         if (N <= 0) {
//             System.out.println("N must be greater than 0");
//             return;
//         }

//         // Step 1: Find n
//         long n = 0;
//         while ((n + 1) * (n + 2) / 2 <= N) {
//             n++;
//         }
//         n--;

//         if (n < 0) {
//             System.out.println("Invalid value of n calculated");
//             return;
//         }

//         // Step 2: Calculate a
//         long a = N - (n + 1) * (n + 2) / 2;

//         // Step 3: Calculate the sum using the binary representation of a
//         long sum = powerOfThree(n);
//         for (int i = 0; a > 0; i++) {
//             if ((a & 1) == 1) {
//                 sum += powerOfThree(i);
//             }
//             a >>= 1;
//         }

//         // Output the result
//         System.out.println(sum);
//     }

//     // Method to compute 3^x without using Math.pow
//     private static long powerOfThree(long x) {
//         long result = 1;
//         long base = 3;
//         while (x > 0) {
//             if ((x & 1) == 1) {
//                 result *= base;
//             }
//             base *= base;
//             x >>= 1;
//         }
//         return result;
//     }
// }
// ``
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextLong(); // 사용자로부터 입력을 받습니다.
		long answer = 0;        // 결과값을 저장할 변수입니다.
        int count = 0;          // 현재 비트 위치를 저장할 변수입니다.

        while (N > 0) { // N이 0보다 큰 동안 반복합니다.
            if ((N & 1) == 1) { // N의 마지막 비트가 1인지 확인합니다.
                answer += power(3, count); // 마지막 비트가 1이라면, 3의 count제곱을 answer에 더합니다.
            }
            count++; // 비트 위치를 증가시킵니다.
            N = (N >> 1); // N을 오른쪽으로 1비트 이동시켜서 다음 비트를 확인합니다.
        }

        System.out.println(answer); // 결과값을 출력합니다.
	}
	
	private static long power(long a, long b) {
		if(b == 0) return 1; // b가 0이면 a^0 = 1을 반환합니다.
		if(b == 1) return a; // b가 1이면 a^1 = a를 반환합니다.
		
		long temp = power(a, b / 2); // a^(b/2)를 계산합니다.
		
		if(b % 2 == 0) {
			return (temp * temp); // b가 짝수이면, a^b = (a^(b/2))^2
		} else {
			return ((temp * temp) * a); // b가 홀수이면, a^b = (a^(b/2))^2 * a
		}
	}
}
