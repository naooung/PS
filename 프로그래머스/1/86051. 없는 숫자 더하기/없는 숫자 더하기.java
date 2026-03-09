import java.util.*;

class Solution {
    public int solution(int[] numbers) {

        Arrays.sort(numbers);
        int sum = 0;
        int index = 0;
        
        for (int i = 0; i <= 9; i++) {
            if (index < numbers.length && numbers[index] == i)
                index++;
            else
                sum += i;
        }
        
        return sum;
    }
}