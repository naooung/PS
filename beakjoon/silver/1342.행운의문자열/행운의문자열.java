import java.io.*;
import java.util.*;

public class Main {
    static int length; 
    static int result = 0;
    // 어떤 문자가 몇개 있는지 저장
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        dfs(0, '\0');
        System.out.println(result);
    }

    public static void dfs(int currentLen, char before) {
        if (currentLen == length) {
            result++;
            return;
        }

        for (char c : map.keySet()) {
            int leftNum = map.get(c);

            if (leftNum > 0 && c != before) {
                map.put(c, leftNum - 1);
                dfs(currentLen + 1, c);
                map.put(c, leftNum); // 원래 상태로 복귀하여 다른 문자도 탐색
            }
        }
    }
}