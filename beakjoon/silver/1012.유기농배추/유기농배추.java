import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = {0, -1, 0, 1};
  static int[] dy = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int a = 0; a < t; a++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int[][] ground = new int[n][m];

      for (int b = 0; b < k; b++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        ground[y][x] = 1; 
      }

      int result = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (ground[i][j] == 1) {
            ArrayDeque<int[]> point = new ArrayDeque<>();
            point.add(new int[]{i, j});
            ground[i][j] = 0;

            while (!point.isEmpty()) {
              int[] p = point.poll();

              for (int d = 0; d < 4; d++) {
                int newx = p[0] + dx[d];
                int newy = p[1] + dy[d];

                if (newx >= 0 && newx < n && newy >= 0 && newy < m
                    && ground[newx][newy] == 1) {
                  point.add(new int[]{newx, newy});
                  ground[newx][newy] = 0; 
                }
              }
            }

            result++;
          }
        }
      }

      System.out.println(result);
    }
  }
}