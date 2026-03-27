import java.util.*;

class Solution {
    public String solution(String s) {
        
        // 전체 문자열 소문자로 변경
        s = s.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        
        // 맨 앞 문자는 대문자로 변경하여 결과문자열에 추가
        sb.append(Character.toUpperCase(s.charAt(0)));
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 현재가 공백이면 다음을 위해 flag on
            if (c == ' ' && !flag) flag = true;
            
            // 현재가 공백이 아니고 이전이 공백이었다면 대문자로 변경
            else if (c != ' ' && flag) {
                flag = false;
                c = Character.toUpperCase(c);
            }
            
            // 공백이 연속으로 나오거나 이어지는 문자열이면 그대로 소문자를 결과문자열에 추가
            sb.append(c);
        }
        
        return sb.toString();
    }
}