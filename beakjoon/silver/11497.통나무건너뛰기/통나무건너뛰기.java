import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testcase = Integer.parseInt(br.readLine());

    // 테스트케이스만큼 반복
    for (int t = 0; t < testcase; t++) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      // 통나무 길이 저장
      int wood[] = new int[n];
      for (int i = 0; i < n; i++)
        wood[i] = Integer.parseInt(st.nextToken());

      // 오름차순 정렬
      Arrays.sort(wood);

      // 제일 작은 수를 0에 저장하고 양쪽에 순서대로 작은 수를 삽입
      int result[] = new int[n];
      result[0] = wood[0];
      int right = 1;
      int left = n - 1;

      for (int i = 1; i < n; i++) {
        if (i % 2 != 0) { // 홀수라면 오른쪽에 저장
          result[right] = wood[i];
          right++;
        }
        else { // 짝수라면 왼쪽에 저장
          result[left] = wood[i];
          left--;
        }
      }

      // 가장 큰 높이 차 구하기, 맨처음과 맨마지막도 비교
      int max = -1;
      for (int i = 0; i < n - 1; i++) {
        max = Math.max(max, Math.abs(result[i] - result[i + 1]));
      }
      max = Math.max(max, Math.abs(result[n - 1] - result[0]));

      System.out.println(max);
    }
  }
}

/**
 * 1. sort로 오름차순 정렬
 * 2. 맨 처음에 제일 작은 숫자 넣기 + 양쪽에 작은 수 넣기
 */