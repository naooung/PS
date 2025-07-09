import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int num[];
  static int result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    num = new int[n];
    for (int i = 0; i < n; i++)
      num[i] = Integer.parseInt(br.readLine());

    if (n == 1) {
      System.out.println(0);
      return;
    }

    while (true) {
      int maxIdx = -1;
      int maxVote = -1;

      // 1등 찾기
      for (int i = 1; i < n; i++) {
        if (num[i] > maxVote) {
          maxVote = num[i];
          maxIdx = i;
        }
      }

      // [0]이 1등이면 종료
      if (num[0] > maxVote)
        break;

      // 1등 표 가져오기
      num[maxIdx]--;
      num[0]++;
      result++;
    }

    System.out.println(result);
  }
}