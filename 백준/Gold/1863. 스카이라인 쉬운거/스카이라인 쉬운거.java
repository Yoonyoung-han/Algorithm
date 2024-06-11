import java.io.*;
import java.util.Stack;


/*
* 최소 건물 수
* 높은 고도 스택에 넣기
* 낮은 고도 만나면 스택에서 빼고 cnt++
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 윤곽 제시 줄
        Stack<Long> stack = new Stack<>();
        int peakCount = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                peakCount++;
            }

            if ( stack.isEmpty() || stack.peek() < y ){
                stack.push(y);
            }

        }

        // 스택에 남은 원소 cnt
        while (!stack.isEmpty() && stack.peek() > 0) {
            stack.pop();
            peakCount++;
        }

        bw.write(peakCount + "\n");

        bw.flush();
        bw.close();
    }


}
