import java.io.*;
import java.util.*;

public class Main {
  static int paper[][];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // paper 배열 저장
    paper = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < m; j++)
        paper[i][j] = Integer.parseInt(st.nextToken());
    }   

    // paper을 순회하며 bfs로 그림의 크기를 확인하고 그림의 개수와 큰크기 갱신
    int count = 0;
    int maxSize = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) {
        if (paper[i][j] == 1) {
            count++;
            maxSize = Math.max(maxSize, bfs(i, j));
        }
      }
    
    System.out.println(count + " " + maxSize);
  }

  public static int bfs(int startX, int startY) {
    int dx[] = {1, 0, -1, 0};
    int dy[] = {0, 1, 0, -1};
    int size = 1;

    ArrayDeque<Point> deque = new ArrayDeque<>();
    deque.add(new Point(startX, startY));
    paper[startX][startY] = 0;

    while (!deque.isEmpty()) {
      Point p = deque.poll();

      for (int i = 0; i < 4; i++) {
        int x = p.x + dx[i];
        int y = p.y + dy[i];

        if (x < 0 || x >= paper.length || y < 0 || y >= paper[0].length || paper[x][y] == 0)
          continue;
        else {
          deque.add(new Point(x, y));
          paper[x][y] = 0;
          size++;
        }
      }
    }
    return size;
  }
}

class Point {
  int x, y;
  
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}