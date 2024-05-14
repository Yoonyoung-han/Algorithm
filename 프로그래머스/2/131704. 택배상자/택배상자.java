import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        // 보조 벨트
        Stack<Integer> assistBelt = new Stack<>();
        // 순서대로 들어온 물건
        for(int i= 1; i<=order.length; i++){
            // 보조 벨트에 일단 담음 -> 어차피 맨위 물건 비교나 메인 벨트 비교나 그게 그거임
            assistBelt.push(i);
            while(!assistBelt.empty() && order[answer] == assistBelt.peek()){
                // 보조 스택이 비어있지 않고, 맨 위에거가 순서에 맞으면 카운팅, 해당 물건 빼기
                answer++;
                assistBelt.pop();
            }
        }
        return answer;
    }
}