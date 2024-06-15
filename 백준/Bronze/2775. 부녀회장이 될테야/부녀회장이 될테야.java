import java.io.*;

/*
* 문제 해석
* a-1층의 1-b까지의 사람을 합한 수 = a층 b호에 사는 사람
* k층 n호에는 몇명이 살고 있는지 출력
* 0층 1호부터 있음
* 0층의 i호는 1명씩 산다
*
* 해결 법
* k*n호까지 매트릭스 생성 dy[0][i] 1->n 명까지 초기화
* k-1까지 반복
* dy[i]+ 이전 층 같은 호수 사람 전까지의 사람
* */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 수

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine()); // k층 0부터 시작
            int n = Integer.parseInt(br.readLine()); // n호 1부터 시작

            int[][] dy = new int[k + 1][n + 1];

            // 0층 초기화 1,2,3,4...
            for (int j = 1; j <= n; j++) {
                dy[0][j] = j;
            }

            // 1층부터 k층까지 계산
            for (int j = 1; j <= k; j++) {
                // 1호부터 n호까지 계산
                for (int l = 1; l <= n; l++) {
                    // j층 l호 = 밑에층 같은 호수 + 같은층 옆에 호수
                    dy[j][l] = dy[j - 1][l] + dy[j][l - 1];
                }
            }
            bw.write(dy[k][n] + "\n");
            }


            // 출력 버퍼 비우기
            bw.flush();

            // 리소스 닫기
            bw.close();
            br.close();
        }


}



