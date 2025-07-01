import java.io.*;
import java.util.*;

public class Main {
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    ArrayList<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[n + 1];

    dfs(result, visited, 0);
  }

  // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
  public static void dfs(ArrayList<Integer> result, boolean[] visited, int num) {

    // 종료 조건: m개의 조합 완성
    if (num == m) {

      for (int i = 0; i < result.size(); i++)
        System.out.print(result.get(i) + " ");
      System.out.println();

      return;
    }


    // 아직 방문하지 않은 자연수를 조합에 추가하고 재귀 실행
    for (int i = 1; i < n + 1; i++) {

      if (!visited[i]) {
        visited[i] = true;
        result.add(i);
        dfs(result, visited, num + 1);

        result.remove(result.size() - 1); 
        visited[i] = false;
      }
    }
  }
}