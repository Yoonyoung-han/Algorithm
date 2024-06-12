import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
/*
* 문제 해석
* 시 범위 -> 01-12
* 분, 초 범위 -> 00-59
* 해석 가능한 경우의 수 출력
*
* 해결 법
* 각 자리의 숫자가 H M S 부합할 때 cnt++
* 시 분 초의 조합 모두 탐색
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numList = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();

        int result = findCombination(numList);

        bw.write(result+"\n");


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        br.close();
        bw.close();
    }

    // H M S 조합 모두 탐색
    public static int findCombination(int[] timeData) {
        // 0으로 초기화
        int cnt = 0;

        // 모든 가능한 시, 분, 초 조합을 생성
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue; // 이미 쓴 원소는 뺌
                for (int k = 0; k < 3; k++) {
                    if (i == k || j == k) continue; // 이미 쓴 원소는 뺌

                    int hour = timeData[i];
                    int minute = timeData[j];
                    int second = timeData[k];

                    if (isHour(hour) && isMS(minute) && isMS(second)) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    // 시간 맞는지 체크 01-12
    private static boolean isHour(int num){
        return num > 0 && num <13;
    }

    // 분, 초 맞는지 체크 00-59
    private static boolean isMS(int num){
        return num >= 0 && num <= 59;
    }
}
