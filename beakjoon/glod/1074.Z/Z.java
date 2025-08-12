import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(find(n, r, c));
    }

    public static int find(int n, int r, int c) {
        // 종료 조건: 해당 위치까지 도달했을 때
        if (n == 0)
            return 0;

        /* 0 1 네모 네칸 중 어디에 위치하는지 구하기 + 블록 크기를 줄이고 4를 곱함
         * 2 3                                
         */
        return 2 * (r % 2) + (c % 2) + 4 * find(n - 1, r / 2, c / 2);
    }
}