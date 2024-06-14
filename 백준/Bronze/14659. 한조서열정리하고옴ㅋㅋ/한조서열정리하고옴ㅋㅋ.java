import java.io.*;
import java.util.Arrays;
/*
* 문제 해석
* 자기 봉우리보다 낮은 봉우리만 처치 가능
* 높은 봉우리를 만나면 다시 리셋
* 가장 처치를 많이한 횟수
*
* 해결 법
* 처치하는 활잡이 변수
* 자기 자신보다 낮으면 cnt ++
* 자기 자신보다 높으면 cnt 리셋
* max cnt 확인
*
* */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 봉우리이자 활잡이 수
        int[] tops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxWin = 0;
        int cnt = 0;
        int hunter = tops[0];
        for (int i = 1; i < N; i++) {
            if (hunter > tops[i]){
                cnt++;
                maxWin = Math.max(cnt, maxWin);
            } else if (hunter < tops[i]) {
                hunter = tops[i];
                cnt = 0;
            }
        }

        bw.write(maxWin+"\n");


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}


