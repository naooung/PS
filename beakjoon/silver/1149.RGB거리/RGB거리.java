import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3]; 

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken()); 
            cost[i][2] = Integer.parseInt(st.nextToken()); 
        }

        int[][] result = new int[n][3];
        result[0][0] = cost[0][0];
        result[0][1] = cost[0][1];
        result[0][2] = cost[0][2];
        
        for (int i = 1; i < n; i++) {
            result[i][0] = cost[i][0] + Math.min(result[i - 1][1], result[i - 1][2]);
            result[i][1] = cost[i][1] + Math.min(result[i - 1][0], result[i - 1][2]);
            result[i][2] = cost[i][2] + Math.min(result[i - 1][0], result[i - 1][1]);
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++)
            if (result[n - 1][i] < minCost)
                minCost = result[n - 1][i];
        
        System.out.println(minCost);
    }
}