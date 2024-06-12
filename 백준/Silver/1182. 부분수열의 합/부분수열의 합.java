import java.io.*;
import java.util.Arrays;

/*
* 문제 해석
* N개의 정수 수열 중
* 부분 수열의 합이 S가 되는 경우의 수
*
* 해결 법
* 재귀 함수에서 모든 부분 수열 생성
* 생선된 수열의 합을 목표값과 비교
* */

public class Main {
    static int CNT =0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 수열의 길이
        int S = Integer.parseInt(input[1]); // 목표 합

        int[] numList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        checkSum(numList,0,0,S);

        bw.write(CNT+"\n");


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

    private static void checkSum(int[] numList, int index, int currentSum, int goal) {
        if (index == numList.length) {
            return;
        }

        // 현재 인덱스의 수를 더한 경우
        if (currentSum + numList[index] == goal) {
            CNT++;
        }
        checkSum(numList, index + 1, currentSum + numList[index], goal);

        // 현재 인덱스의 수를 더하지 않은 경우
        checkSum(numList, index + 1, currentSum, goal);
    }

}
