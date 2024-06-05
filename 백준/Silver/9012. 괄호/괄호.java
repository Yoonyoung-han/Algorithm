import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
* 스택 사용 문제
* (를 스택에 넣고, )를 만나면 뺌
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 문자열 갯수

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split("");
            Stack<String> vpsStack = new Stack<>();
            for (String str: s) {
                // 비었거나, ( 이거면 넣음
                if (vpsStack.isEmpty() || str.equals("(")){
                    vpsStack.push(str);
                }else if (vpsStack.peek().equals("(") && str.equals(")")){ // 페어가 맞으면 뺌
                    vpsStack.pop();
                }
            }
            System.out.println( vpsStack.size()!=0 ? "NO":"YES");
        }

    }

}
