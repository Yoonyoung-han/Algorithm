import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/*
* 문제 해석
* 요청한 금액 그대로 배정 가능 -> 그대로 배정
* 배정 불가능 -> 상한액 계산 후 상한액 이상 -> 상한액 배정
* 배정된 예산 중 최댓값 구하기
*
* 해결 법
* sum <= 예산액 -> max값
* sum > 예산액 -> 상한액 계산
* 값이 큰 순서 대로 정렬
* 이분 탐색
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 지방 수

        // 내림차순 정렬
        int[] requests = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::valueOf).toArray();

        long M = Long.parseLong(br.readLine()); // 총예산

        int maxRequest = requests[0]; // 최대 예산 요청

        // 이분 탐색을 통해 상한액을 결정
        int left = 0, right = maxRequest;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for (int request : requests) {
                sum += Math.min(request, mid); // 요청값 , 중간 값보다 작은 수 더하기
            }

            if (sum <= M) {
                answer = mid; // 현재 상한액으로 가능한 경우
                left = mid + 1; // 더 큰 상한액을 탐색하기 위해 범위를 오른쪽으로 이동
            } else {
                right = mid - 1; // 상한액을 줄여야 하는 경우
            }
        }

        bw.write(answer+"\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

}



