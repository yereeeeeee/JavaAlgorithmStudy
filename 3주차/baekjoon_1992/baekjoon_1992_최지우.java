package Java_03_hw;

import java.util.*;
import java.io.*;

public class baekjoon_1992_최지우 {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        quadtree(n, 0, 0);
        System.out.println(sb.toString());
    }

    static int quadtree(int n, int x, int y) {
        int piv = arr[x][y];

        if (n==1) {
            sb.append(piv);
            return 1;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int nx = x+i; int ny = y+j;
                if (arr[nx][ny] != piv) {
                    sb.append("(");
                    quadtree(n/2, x, y);
                    quadtree(n/2, x, y+n/2);
                    quadtree(n/2, x+n/2, y);
                    quadtree(n/2, x+n/2, y+n/2);
                    sb.append(")");
                    return 0;
                }
            }
        }
        sb.append(piv);
        return 1;
    }
}
