import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
/*
* 문제 해석
* N장의 카드 -> 3장의 카드
* 합이 M에 최대한 가깝게
* 합 출력
*
* 해결 법
* 3가지 조합되는 카드 다 탐색
* M과 같거나 작은 수들 중에 제일 큰거 출력
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] numList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = findCombination(numList,M);

        bw.write(result+"\n");


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        br.close();
        bw.close();
    }

    // 3장인 조합 되는거 모두 탐색
    public static int findCombination(int[] cards, int goal){

        int maxNum = -1;
        // 3장의 카드를 뽑는 모든 조합을 탐색
        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    // 숫자의 합이 목표 숫자보다 작거나 같으면 최댓값 비교 후 교체
                    if (sum <= goal) {
                        if (sum> maxNum){
                            maxNum = sum;
                        }
                    }
                }
            }
        }

        return maxNum;

    }
}
