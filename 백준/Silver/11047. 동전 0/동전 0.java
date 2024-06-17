import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
* 문제 해석
* 동전 N종류 합 K
* K를 만들기 위한 동전 개수의 최솟값
*
* 해결 법
* K 보다 작은 수 중에 제일 큰 수부터 체크
* 나눈 몫 -> cnt +
* 나눈 나머지 -> 다음 나눌 타겟
* cnt += K / coins[i];
* K %= coins[i];
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0]; // 동전 종류
        int K = input[1]; // 목표값

        int[] coins = new int[N];
        for (int i = N-1; i >=0; i--) { // 거꾸로 채워넣음 ( 내림차순 )
            coins[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (coins[i] <= K) {
                cnt += K / coins[i];
                K %= coins[i];
            }
        }

        bw.write(cnt+"\n");
        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

}



