import java.io.*;
import java.util.Arrays;

/*
* 문제 해석
* 3키로, 5키로 설탕 봉다리
* N 킬로그램 배달할 때 봉지 최소 개수
*
* 해결 법
* dp[n] = n kg 설탕을 나누는데 필요한 최소 봉지수
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 목표 설탕량

        // dp 배열 초기화
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0 kg의 설탕은 봉지가 필요 없음

        for (int i = 1; i <= N; i++) {
            if (i >= 3 && dp[i - 3] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
            if (i >= 5 && dp[i - 5] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        // 결과 출력
        if (dp[N] == Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            bw.write(dp[N] + "\n");
        }
        
        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}



