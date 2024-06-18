import java.io.*;
import java.util.Arrays;

/*
* 문제 해석
* 2*n크기의 직사각형을 1*2, 2*1 타일로 채우는 방법의 수
* 방법의 수/10007로 나눈 나머지 출력
*
* 해결 법
* d[n] = 2*n의 직사각형을 1*2,2*1 타일로 채우는 방법의 수
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 직사각형 가로길이

        // dp 배열 초기화
        int[] dp = new int[1001];
        dp[0] = 0; // 0이면 못채움
        dp[1] = 1; // 1열이면 1*2로만 채움
        dp[2] = 2; // 2열이면 1*2로만 채우든지 2*1로만 채우든지


        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007; // 1*2 타일 하나 더 놓는 경우, 2*1 타일 세로로 놓는 경우 더한거
        }

        bw.write(dp[N] + "\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}



