import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
* 문제 해석
* 서로 같은 번호의 손
* 손은 한 마리 당 한 손만
* 인접한 두 문어가 잡은 손의 번호 = 길이 N의 수열
* (1문어,2문어 잡은 손),(2문어,3문어 잡은 손) .. => 원형 큐 형식
* 사전순으로 제일 앞서는 수열을 출력
*
* 해결 법
* 덱 사용
* [N][8] 로 각 문어의 다리 사용 여부 표시
*
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] hands = new int[N][8];
        for (int i = 0; i < N; i++) {
            for (int j =0; j < 8 ; j++) {
                hands[i][j] = j+1;
            }
        }

        Deque<Integer> deque = new LinkedList<>();
        boolean[][] used = new boolean[N][9]; // 손 번호는 1~8

        // 처음 손은 1로 시작
        deque.add(1);
        used[0][1]  = true;
        used[1][1] = true;

        for (int i = 1; i < N; i++) {
            int[] possibleHands = hands[i];

            for (int hand : possibleHands) {
                if (!used[i % N][hand] && !used[(i + 1) % N][hand]) {
                    deque.add(hand);
                    used[i % N][hand] = true;
                    used[(i + 1) % N][hand] = true;
                    break;
                }
            }
        }

        while (!deque.isEmpty()) {
            bw.write(deque.pollFirst() + " ");
        }

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

}



