import java.io.*;

/*
* 문제 해석
* N개의 돌, 1개 또는 3개 가져갈 수 있음
* 이기는 사람 구하기 상근이가 먼저 함
* 상근 = SK, 창영 = CY
*
* 해결 법
* 홀수면 상근 이기는거 아닌가..?
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 돌 수

        if(N%2==0){
            bw.write("CY\n");
        }else bw.write("SK\n");


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}



