import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int num[];
  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    num = new int[n];
    result = 0;

    for (int i = 0; i < n; i++) 
        num[i] = Integer.parseInt(br.readLine());

    // 가장 투표 수가 많은 사람의 표를 1표씩 가져온다.
    while (true) {
        int winPerson = still();
        if (num[0] > num[winPerson])
            break;
    }
      System.out.println(result);
  }

  // 가장 많이 투표를 받은 사람 번호 반환
  public static int still() {
    int winPerson = 1;
    // 가장 많은 투표를 받은 사람을 찾는다.
    for (int i = 1; i < n; i++) {
        if (num[winPerson] < num[i])
            winPerson = i;
    }

    // 해당 사람의 투표를 1개 뺏고 [0]에게 추가
    num[winPerson] -= 1;
    num[0] += 1;
    result += 1;

    return winPerson;
  }
}