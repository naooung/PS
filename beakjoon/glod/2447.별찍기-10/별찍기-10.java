import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (notStar(i, j)) 
                    result.append(' ');
                else 
                    result.append('*');
            }
            result.append('\n');
        }

        System.out.print(result.toString());
    }

    static boolean notStar(int x, int y) {
        
        while (x > 0 && y > 0) {
            if (x % 3 == 1 && y % 3 == 1) 
                return true;

            x /= 3;
            y /= 3;
        }
        return false;
    }
}