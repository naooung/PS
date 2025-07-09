import java.io.*;
import java.util.*;

public class Main {
  static String s;
  static char c[];
  static HashSet<String> set;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine();
    set = new HashSet<>();

    for (int i = 0; i < s.length(); i++)
      addString(i);

    System.out.println(set.size());
  }

  // i부터의 부분 문자열을 set에 추가하는 함수
  public static void addString(int i) {
    StringBuilder sb = new StringBuilder();

    for (int n = i; n < s.length(); n++)
      set.add((sb.append(String.valueOf(s.charAt(n)))).toString());
  }
}

/**
 * a ab aba abab ababc
 * b ba bab babc
 * a(X) ab(X) abc
 * b(X) bc
 * c
 */