import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int score[][] =  new int[n][2];

            // (서류 성적, 면접 성적) 저장
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                score[j][0] = Integer.parseInt(st.nextToken());
                score[j][1] = Integer.parseInt(st.nextToken());
            }

            // 서류 성적[0]을 기준으로 오름차순 정렬 -> 1등은 무조건 합격
            Arrays.sort(score, Comparator.comparingInt(a -> a[0]));
            int result = 1;
            int front = score[0][1];

            // 자신의 면접 성적이 서류 성적의 상위 성적인 사람들보다 높아야 함
            for (int j = 1; j < n; j++) {
                if (score[j][1] < front) {
                    front = score[j][1];
                    result++;
                }
            }

            System.out.println(result);
        }
    }
}