import java.io.*;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int n;
    private static int m;
    private static int[][] box;

    private static ArrayDeque<Point> queue = new ArrayDeque<>();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int count = 0;

        box = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                // 1인 부분부터 bfs 탐색
                if (box[i][j] == 1) {
                    queue.add(new Point(i, j, 0));
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        Point p = null; // 마지막 p만 남음

        while (!queue.isEmpty()) {
            p = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if (0 <= newX && n > newX && 0 <= newY && m > newY) {
                    if (box[newX][newY] == 0) {
                        box[newX][newY] = 1;
                        queue.add(new Point(newX, newY, p.day + 1));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0)
                    return -1;
            }
        }
        
        return p.day;
    }
}

class Point {
    int x;
    int y;
    int day;

    public Point(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}