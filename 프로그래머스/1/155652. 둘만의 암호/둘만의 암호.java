import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder result = new StringBuilder();
    
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < skip.length(); i++)
            set.add(skip.charAt(i));

        // 문자열 순회
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // index만큼 움직이기 (z가 나오면 a로 변경 / skip이 나오면 pass)
            for (int j = 0; j < index; j++) {
                // 다음 인덱스로 변환
                if (c == 'z') c = 'a';
                else c++;
                
                // skip 포함 여부 확인
                if (set.contains(c)) j--;
            }
            result.append(c);
        }
        
        return result.toString();
    }
}