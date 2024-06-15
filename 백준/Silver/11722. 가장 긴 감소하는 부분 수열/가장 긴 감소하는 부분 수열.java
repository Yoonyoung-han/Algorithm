import java.io.*;
import java.util.Arrays;

/*
* 문제 해석
* 수열 A에서 감소하는 부분수열의 최대 길이
*
* 해결 법
* dp 배열 수열 A 길이 만큼 생성
* dp[n] = A[n]으로 만들수 있는 감소하는 부분 수열의 최대 길이
* */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine()); // A의 길이

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[len];
        Arrays.fill(dp, 1); // 각 원소 자체로 길이 1의 부분 수열을 가짐

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[i]){ // 감소하는 수열  = 지나온 값 > 현재 비교값
                    dp[i] = Math.max(dp[i], dp[j] + 1); // dp 배열 값+1이랑 기존 값 비교해서 더 큰거 넣음
                }
            }
        }

        int answer = Arrays.stream(dp).max().getAsInt();

        bw.write(answer+"\n");


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}



