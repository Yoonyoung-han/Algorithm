import java.io.*;
import java.util.Arrays;

/*
* 문제 해석
* N개의 도시 , 도시 마다 리터당 요금 다름
* 제일 왼쪽에서 제일 오른 쪽 도시로 이동하는 최소 비용
*
* 해결 법
* 첫 도시 요금 * 첫 도시 거리 = 초기값
* N-1만큼 반복
* 현재 요금 vs 전 도시 기준 요금 중 최저 요금
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시 수

        int[] distances = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 거리 길이
        long[] prices = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray(); // 도시 요금 수

        long sum = 0;
        long minCost = prices[0]; // 주유소 최소 가격

        for (int i = 0; i < N-1; i++) {
            /*
             *  현재 주유소가 이전 주유소의 기름값보다 쌀 경우
             *  minCost를 갱신해준다.
             */
            if(prices[i] < minCost) {
                minCost = prices[i];
            }

            sum += (minCost * distances[i]);
        }

        bw.write(sum+"\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

}



