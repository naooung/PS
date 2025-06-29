import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int result = 0;

    // m과 m의 각 자릿수를 더한 값이 n이라면 반복문 탈출
    for (int i = 1; i < n; i++) {
      int m = i;
      int sum = m;

      while (m > 0) {
        sum += (m % 10);
        m /= 10;
      }

      if (sum == n) {
        result = i;
        break;
      }
    }
    System.out.println(result);
  }
}