import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
/*
* 문제 해석
* 지각시간 = t
* 수업 일찍 마치는 시간 = s
* s = t^2
* 수업 시간 d에서 최대 지각 시간 구하기
*
* 해결 법
* d까지 반복문 돌면서 t+t*t <=d 일때 까지 탐색
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int d = Integer.parseInt(br.readLine());
            int maxTime=0;
            for (int j = 1; j < d; j++) {
                if (j+j*j <= d){
                    maxTime = j;
                }
            }
            bw.write(maxTime+"\n");
        }



        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        br.close();
        bw.close();
    }

}
