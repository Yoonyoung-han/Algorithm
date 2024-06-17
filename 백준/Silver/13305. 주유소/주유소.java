import java.io.*;
import java.util.Arrays;

/*
* 문제 해석
* N개의 도시 , 도시 마다 리터당 요금 다름
* 제일 왼쪽에서 제일 오른 쪽 도시로 이동하는 최소 비용
*
* 해결 법
* 첫 도시 요금 * 전체 거리 = 초기값
* N-1만큼 반복
* 이동 할때 마다 요금 누적
* (누적 요금 + 현재 도시부터 남은 거리 요금) 초기값 비교 
* 
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시 수

        int[] distances = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 거리 길이
        long[] prices = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray(); // 도시 요금 수

        int totalDist = Arrays.stream(distances).sum(); // 총거리
        long minCost = totalDist * prices[0];
        int accumulateCost = 0; // 누적 비용

        for (int i = 0; i < N-1; i++) {
            accumulateCost += prices[i] * distances[i];

            // 현재 도시부터 마지막 도시까지의 남은 거리에 대한 주유 비용 계산
            int restDist = totalDist - distances[i];
            long currCost = prices[i + 1] * restDist;

            // 최소 비용 업데이트
            minCost = Math.min(minCost, accumulateCost + currCost);
        }

        bw.write(minCost+"\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

}



