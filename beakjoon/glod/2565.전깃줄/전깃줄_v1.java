import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int result;
    static int line[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        line = new int[n][2];

        // 전깃줄 번호 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[i][0] = a;
            line[i][1] = b;
        }  

        // 전깃줄[0] 오름차순 정렬
        Arrays.sort(line, (a, b) -> a[0] - b[0]);

        // 전깃줄[1]이 오름차순 기준으로 정렬했을 때 가장 긴 조합
        result = Integer.MAX_VALUE;
        for (int i = 0; i < line.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            choose(list, i);
        }

        System.out.println(result);
    }

    // ArrayList의 마지막에 있는 원소보다 큰 수만 고른 후 line의 마지막까지 오면 종료하는 함수
    static void choose(ArrayList<Integer> select, int currentA) {
        // 모든 전깃줄을 순회했다면 없어야하는 전깃줄 수 반환
        result = Math.min(result, n - select.size());

        if (currentA == n) return;

        // 순회했던 인덱스인 currentA부터 마지막까지 순회하면서 마지막에 있는 원소보다 큰 수만 고른 후 재귀
        for (int i = currentA + 1; i < n; i++) {
            if (line[select.get(select.size() - 1)][1] < line[i][1]) {
                ArrayList<Integer> newSelect = new ArrayList<>(select);
                newSelect.add(i);
                choose(newSelect, i);
            }
        }
    }
}  