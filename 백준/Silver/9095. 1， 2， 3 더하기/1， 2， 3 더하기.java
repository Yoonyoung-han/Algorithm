import java.io.*;
import java.util.Arrays;

/*
* 문제 해석
* 정수 n -> 1,2,3으로 만드는 방법의 수 구하기
*
* 해결 법
* Dp[n] = 1,2,3 조합으로 n이 나온 최대 경우의 수
* 1,2,4
* d[4] = dp[3] + dp[2] + dp[1]
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // testcase 수

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            bw.write(dp[n] + "\n");
        }

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}



