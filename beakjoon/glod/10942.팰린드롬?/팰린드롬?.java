import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 숫자 저장
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            array[i] = Integer.parseInt(st.nextToken());

        int result[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) // 1칸: 무조건 팰린드롬 (5)
            result[i][i] = 1;
        
        for (int i = 1; i < n; i++) // 2칸: 옆과 동일하면 팰린드롬 (5~6)
            if (array[i] == array[i + 1])
                result[i][i + 1] = 1;
        
        for (int i = n; i >= 1; i--) // 3칸 이상: 끝이 같고 가운데 팰린드롬 (1~5)
            for (int j = i + 2; j <= n; j++)
                if (array[i] == array[j] && result[i + 1][j - 1] == 1)
                    result[i][j] = 1;

        // 질문 저장
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); 
            int e = Integer.parseInt(st.nextToken());

            bw.write(result[s][e] + "\n");
        }
        bw.flush();
    }
}
