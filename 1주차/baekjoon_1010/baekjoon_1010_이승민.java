package Silver;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class baekjoon_1010_이승민 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n, m;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            // mCn
            BigInteger all = factorial(m);
            BigInteger divide1 = factorial(m - n);
            BigInteger divide2 = factorial(n);
            BigInteger result = all.divide(divide1.multiply(divide2));
            System.out.println(result);
        }
    }

    static BigInteger factorial(int i) {
        BigInteger result = BigInteger.ONE;
        for (int j = 1; j <= i; j++) {
            result = result.multiply(BigInteger.valueOf(j));
        }
        return result;
    }
}
