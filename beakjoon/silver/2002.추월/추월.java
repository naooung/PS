import java.io.*;
import java.util.*;

public class Main {
  private static int n;
  private static LinkedList<String> in;
  private static LinkedList<String> out;
  private static int result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    in = new LinkedList<>();
    out = new LinkedList<>();
    for (int i = 0; i < n; i++)
      in.add(br.readLine());
    for (int i = 0; i < n; i++)
      out.add(br.readLine());

    while (out.size() != 0) {
      String s = out.get(0);
      if (!s.equals(in.get(0))) {
        in.remove(s);
        result++;
      }
      else
        in.remove(0);
      out.remove(0);
    }

    System.out.println(result);
  }
}