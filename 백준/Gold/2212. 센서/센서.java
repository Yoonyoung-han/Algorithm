import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/*
* 문제 해석
* N개의 센서와 K개의 집중국
* N개의 센서는 적어도 하나의 집중국과 통신해야함
* 집중국의 수신 가능영역의 거리의 합이 최솟값인 경우
*
* 해결 법
* K >=N -> 0
* 그게 아니면
* 센서 죄표를 중복 없이 오름차순 정렬 => 트리 셋 사용
* 배열의 차이를 내림 차순으로 정렬
* 집중국 개수의 k-1 만큼 최대 차이 뺄 수 있음
*
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sensor = Integer.parseInt(br.readLine()); // 센서 수
        int k = Integer.parseInt(br.readLine()); // 집중국 개수
        if (k >= sensor){
            bw.write(0+"\n");
        }else {
            int[] sensorVal = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .distinct()
                    .sorted()
                    .toArray();

            int n = sensorVal.length;  // 중복을 제거한 센서 수
            Integer[] diff = new Integer[n - 1];

            for (int i = 0; i < n-1; i++) {
                diff[i] = sensorVal[i+1] - sensorVal[i];
            }

            Arrays.sort(diff, Collections.reverseOrder());

            int sum = Arrays.stream(diff, k - 1, diff.length).mapToInt(Integer::intValue).sum();

            bw.write(sum + "\n");

        }




        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

}



