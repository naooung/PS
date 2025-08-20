class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int currentHealth = health;
        int time = 0;
        
        for (int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int attackPower = attacks[i][1];
            
            // 1. 공격 받기
            currentHealth -= attackPower;
            if (currentHealth <= 0)
                return -1;
            
            // 2. 다음 공격시간보다 붕대감기 시간이 작으면 붕대감기 실행 (마지막일 때 빼고)
            if (i < attacks.length - 1) {
                int remainTime = attacks[i + 1][0] - (attackTime + 1);
                
                // 붕대감기 t초 수행
                while (remainTime >= t) {
                    int healed = t * x + y;
                    currentHealth = currentHealth + healed < health ? currentHealth + healed : health;
                    remainTime -= t;
                }

                // t초 연속 불가능 -> 남은 시간 만큼 회복 *x
                if (remainTime > 0 && currentHealth < health) {
                    int healed = remainTime * x;
                    currentHealth = currentHealth + healed < health ? currentHealth + healed : health;
                }
            }
        }
        return currentHealth;
    }
}

/**
 * 공격을 받은 후, 다음 공격시간보다 붕대 시전시간이 작다면 붕대감기 가능 (마지막 공격일 경우 제외)
 * 붕대감기 시전시 -> 체력 회복(추가 회복량 고려)
 * 체력 0 이하인 경우 -1 return 
 */