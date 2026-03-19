import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        ArrayList<Character> sameNum = new ArrayList<>();

        // 문자와 문자의 개수 저장
        HashMap<Character, Integer> xmap = new HashMap<>();
        for (int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            xmap.put(c, xmap.getOrDefault(c, 0) + 1);
        }
        
        // 같은 문자가 있는지 확인 후 있으면 sameNum에 추가하고 map에서 value -1
        for (int j = 0; j < Y.length(); j++) {
            char c = Y.charAt(j);
            
            if (xmap.containsKey(c) && xmap.get(c) > 0) {
                sameNum.add(c);
                xmap.put(c, xmap.get(c) - 1);
            }
        }
        if (sameNum.isEmpty()) return "-1";
        
        // sameNum 내림차순 후 StringBuilder로 붙여서 출력
        sameNum.sort(Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < sameNum.size(); i++)
            sb.append(sameNum.get(i));
        
        // 0으로 이루어진 문자열이면 0 리턴 
        if (sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}