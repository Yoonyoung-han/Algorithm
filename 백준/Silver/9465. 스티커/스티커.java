import java.io.*;

/*
* 문제 해석
* 2행 n열 인접하는 모든 칸은 쓸모 없어짐
* 스티커의 점수의 합이 최대값이 되게 하고 싶다.
* 스티커 점수의 최댓값을 구하자
* 두 변을 공유하지 않는 스티커의 최대 점수
*
* 해결 법
* 자신의 왼쪽 대각선 (위의 배열일 경우 왼쪽 아래, 아래 배열일 경우 왼쪽 위) 에 존재하는 값 다음에 올 수 있고
* 자신의 왼쪽 왼쪽 에 위치한 값 다음에 올 수 있다.
* DP[0][N] = Max(DP[1][N-1], DP[1][N-2])
* DP[1][N] = Max(DP[0][N-1], DP[0][N-2])
*
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()); // 열의 수
            int[][] arr = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            // 스티커 점수 초기화
            for (int j = 0; j < 2; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(input[k - 1]);
                }
            }

            // dp 초기화
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = arr[0][j] + Math.max(dp[1][j - 1], dp[1][j - 2]);
                dp[1][j] = arr[1][j] + Math.max(dp[0][j - 1], dp[0][j - 2]);
            }

            int result = Math.max(dp[0][n], dp[1][n]);
            bw.write(result + "\n");
        }

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

}



