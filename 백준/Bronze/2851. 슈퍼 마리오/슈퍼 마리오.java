import java.io.*;

/*
* 문제 해석
* 일렬로 정렬된 버섯
* 버섯 점수 합 최대한 100에 가깝게 먹기
* 최종 점수 출력, 100에 가까운 수가 2개면 큰값
*
* 해결 법
* 일렬로 순차적으로 더해가며 100에 가장 가까운 합을 찾는다.
* 현재 합이 100을 초과하면 이전 합과 비교하여 100에 더 가까운 값을 선택한다.
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] mushrooms = new int[10];

        for (int i = 0; i < 10; i++) {
            mushrooms[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        int bestScore = 0;

        for (int i = 0; i < 10; i++) {
            sum += mushrooms[i];
            if (Math.abs(100 - sum) <= Math.abs(100 - bestScore)) {
                bestScore = sum;
            }
        }


        bw.write(bestScore+"\n");


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

}
