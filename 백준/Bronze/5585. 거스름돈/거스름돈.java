import java.io.*;
/*
* 문제 해석
* 거스름돈 갯수가 최솟값
* 1000엔 - 지불할 돈
* 500,100,50,10,5,1
*
* 해결 법
* 거스름 돈의 액수가 가장 큰 것부터 cnt++
*
* */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] coins = {500,100,50,10,5,1}; // 큰거부터 세기
        int cnt = 0;
        int target = 1000 - Integer.parseInt(br.readLine());

        for (int i = 0; i < coins.length; i++) {
            if (target ==0) break;
            cnt += target/coins[i];
            target %= coins[i];
        }

        bw.write(cnt+"\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}


