import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testcase = Integer.parseInt(br.readLine());

    // 테스트케이스만큼 반복
    for (int t = 0; t < testcase; t++) {
      int n = Integer.parseInt(br.readLine());

      // 스티거 점수 저장
      int[][] score = new int[2][n];
      for (int i = 0; i < 2; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++)
          score[i][j] = Integer.parseInt(st.nextToken());
      }

      // dp로 누적 최댓값 계산
      int[][] save = new int[2][n];
      save[0][0] = score[0][0];
      save[1][0] = score[1][0];

      for (int j = 1; j < n; j++) {
        if (j > 1) { // 대각선과 대각선 옆 비교
          save[0][j] = score[0][j] + Math.max(save[1][j - 1], save[1][j - 2]);
          save[1][j] = score[1][j] + Math.max(save[0][j - 1], save[0][j - 2]);
        }
        else if (j == 1) { // 대각선과의 합 저장
          save[0][1] = score[0][1] + save[1][0];
          save[1][1] = score[1][1] + save[0][0];
        }
      }
      System.out.println(Math.max(save[0][n - 1], save[1][n - 1]));
    }
  }
}