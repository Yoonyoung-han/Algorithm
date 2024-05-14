import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Character> stStack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++){
            // k가 0이 될때까지 반복, stStack.peek()보다 크면 기존거 제거하고 다시 담기
            while (!stStack.isEmpty() && k > 0 && number.charAt(i) > stStack.peek()){
                    stStack.pop();
                    k--;
            }
            // 스택에 넣기
            stStack.push(number.charAt(i));
        }
        
        // Stack에서 문자를 꺼내서 StringBuilder에 추가
        StringBuilder sb = new StringBuilder();
        while (!stStack.isEmpty()) {
            // 인덱스 0부터 차례대로 -> 리버스
            sb.insert(0, stStack.pop());
        }
        
        // 남은 숫자(5,4,3,2,1일 경우 k가 남음)는 뒤에서 제거
        sb.delete(sb.length() - k, sb.length());
        
        // `StringBuilder`를 문자열로 변환하고 반환
        return sb.toString();
    }
}