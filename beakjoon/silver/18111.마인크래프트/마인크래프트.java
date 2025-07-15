import java.io.*;
import java.util.*;

public class Main {
  private static int n;
  private static int m;
  private static int b;
  private static int[][] block;
  private static int minTime = Integer.MAX_VALUE;
  private static int height = 0; 

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    block = new int[n][m];
    int max = -1;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        block[i][j] = Integer.parseInt(st.nextToken());
        max = Math.max(max, block[i][j]);
        min = Math.min(min, block[i][j]);
      }
    }

    for (int a = max; a >= min; a--)
        possible(a);

    System.out.println(minTime + " " + height);
  }

  // 모든 블록을 a개로 만드는 것이 가능한지 확인하는 함수
  public static void possible(int a) {
    int copyB = b;
    int time = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        if (block[i][j] > a) { // 만드려는 블록보다 높으면 빼고 인벤토리 넣기
          int count = block[i][j] - a;
          time += count * 2;
          copyB += count;
        }
        else if (block[i][j] < a) { // 만드려는 블록보다 낮으면 인벤토리에서 꺼내기
          int count = a - block[i][j];
          time += count;
          copyB -= count;
        }
      }
    }

    if (copyB >= 0 && minTime > time) {
        minTime = time;
        height = a;
    }
  } 
}

/** 처음 작성한 코드
public class Main {
    private static int n;
    private static int m;
    private static int b;
    private static int[][] block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        block = new int[n][m];
        int max = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
                block[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, block[i][j]);
                min = Math.min(min, block[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;

        for (int a = max; a >= min; a--) {
            int time = possible(a);

            if (time != -1) {
                // 갱신 조건: 최소 시간이거나 동일한 시간이지만 높이가 더 높을 때
                if (time < minTime || (time == minTime && a > height)) {
                    minTime = time;
                    height = a;
                }
            }
        }
        System.out.println(minTime + " " + height);
    }

    // 모든 블록을 a개로 만드는 것이 가능한지 확인하는 함수
    // 가능하다면 time을, 불가능하다면 -1을 return
    public static int possible(int a) {
        int copyB = b;
        int time = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (block[i][j] > a) { // 만드려는 블록보다 높으면 빼고 인벤토리 넣기
                    int count = block[i][j] - a;
                    time += count * 2;
                    copyB += count;
                }
                else if (block[i][j] < a) { // 만드려는 블록보다 낮으면 인벤토리에서 꺼내기
                    int count = a - block[i][j];
                    if (count > copyB) return -1; // 인벤토리 개수 부족이라면 pass
                    time += count;
                    copyB -= count;
                }
            }
        }
        return time;
    }
}
 */