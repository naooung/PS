import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 다 초로 변환해서 changes 저장
        int[] changes = new int[4];
        changes[0] = Integer.parseInt(video_len.substring(0, 2)) * 60
                   + Integer.parseInt(video_len.substring(3));
        
        changes[1] = Integer.parseInt(pos.substring(0, 2)) * 60
                   + Integer.parseInt(pos.substring(3));
        
        changes[2] = Integer.parseInt(op_start.substring(0, 2)) * 60
                   + Integer.parseInt(op_start.substring(3));
        
        changes[3] = Integer.parseInt(op_end.substring(0, 2)) * 60
                   + Integer.parseInt(op_end.substring(3));

        for (String command : commands) {
            // 오프닝에 있으면 건너뛰기
            if (changes[1] >= changes[2] && changes[1] <= changes[3]) {
                changes[1] = changes[3];
            }

            if ("prev".equals(command)) {
                changes[1] = Math.max(0, changes[1] - 10);
            } else if ("next".equals(command)) {
                changes[1] = Math.min(changes[0], changes[1] + 10);
            }
        }

        if (changes[1] >= changes[2] && changes[1] <= changes[3]) {
            changes[1] = changes[3];
        }

        int mm = changes[1] / 60;
        int ss = changes[1] % 60;

        String m = (mm < 10 ? "0" : "") + mm;
        String s = (ss < 10 ? "0" : "") + ss;

        return m + ":" + s;
    }
}

/**
 * prev: 현재 위치 - 10s (현재 10s 이하는 0분 0초)
 * next: 현재 위치 + 10s (남은 시간 10초 이하는 동영상 길이)
 * 오프닝 건너뛰기: 현재 재생 위치가 오프닝 구간이면 오프닝 끝나는 위치
 *
 * - command 반복문
 *  1. 현재 위치가 오프닝인지 확인 -> 오프닝이면 건너뛰기 실행
 *  2. if prev ->  +10
 *  3. else if next -> -10
 * - 다 끝나고 오프닝 한번 더 실행해줘야 테스트케이스2에서 오류 안발생
 */