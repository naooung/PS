import java.io.*;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int[][] chess;
    private static int l;
    private static int[] start;
    private static int[] goal;
    private static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            chess = new int[l][l];
            st = new StringTokenizer(br.readLine());
            start = new int[2];
            for (int j = 0; j < 2; j++)
                start[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            goal = new int[2];
            for (int j = 0; j < 2; j++)
                goal[j] = Integer.parseInt(st.nextToken());

            int result = bfs();

            System.out.println(result);
            result = 0;
        }
    }

    public static int bfs() {
        boolean[][] visited = new boolean[l][l];

        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Point p = queue.pollFirst();

            // 종료 조건: 목표 지점에 도착
            if (p.x == goal[0] && p.y == goal[1])
                return p.distance;
            
            // 나이트가 이동 가능한 곳으로 너비우선탐색
            for (int i = 0; i < 8; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if (0 <= newX && l > newX && 0 <= newY && l > newY) {
                    if (!visited[newX][newY]) {
                        queue.add(new Point(newX, newY, p.distance + 1));
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        return 0;
    }
}

class Point {
    int x;
    int y;
    int distance;

    public Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}