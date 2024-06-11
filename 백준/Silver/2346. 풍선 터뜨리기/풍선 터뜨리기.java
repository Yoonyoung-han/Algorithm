import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/*
* 풍선 터뜨리기
* 원형 큐 -> 덱
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 풍선 갯수
        Deque<int[]> balloons = new ArrayDeque<>();
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            balloons.add(new int[]{i + 1, Integer.parseInt(input[i])});
        }

        StringBuilder result = new StringBuilder();

        while (!balloons.isEmpty()){
            int[] curr = balloons.pollFirst();
            result.append(curr[0]).append(" ");

            if (balloons.isEmpty()) break;

            int steps = curr[1];

            if (steps > 0) {
                steps--; // 이미 이동한 상태 이므로 빼줌
                // 양수면 오른쪽 이동
                for (int i = 0; i < steps; i++) {
                    balloons.addLast(balloons.pollFirst());
                }
            } else {
                // 음수면 왼쪽 이동
                for (int i = 0; i < Math.abs(steps); i++) {
                    balloons.addFirst(balloons.pollLast());
                }
            }
        }

        bw.write(result+"");


        bw.flush();
        bw.close();
    }


}
