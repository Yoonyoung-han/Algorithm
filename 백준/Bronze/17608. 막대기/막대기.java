import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
* 스택에 넣고 비교
* peek() 보다 현재 값이 크거나 같다 -> 현재 값이 peek()으로 변경되어야함
* 스택 사이즈 출력
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> intStack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            // 스택 빈 상태 X, 현재 값이 크거나 같을 경우
            while (!intStack.isEmpty() && target >= intStack.peek()) {
                // 스택 값 다 뺌
                intStack.pop();
            }
            intStack.push(target);
        }
        System.out.println(intStack.size());
    }
}
