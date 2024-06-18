import java.io.*;
import java.util.Arrays;

/*
* 문제 해석
* | 예상 등수 - 실제등수 | -> 불만도
* 불만도 총합의 최소값
*
* 해결 법
* 예상 등수를 정렬하여 실제 등수와 차이의 절대값을 더하기
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 학생 수
        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rank);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.abs(rank[i] - (i + 1));
        }

        bw.write(sum + "\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}



