import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        // 비교할 변수 (0 보다 클 경우만 들어가므로 초기값은 -1)
        int value = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != value) {
                answer.add(arr[i]);
                // 비교할 변수 업데이트
                value = arr[i];
            }
        }
        // int[]로 형변환
        return answer.stream().mapToInt(i->i).toArray();
    }
    
}