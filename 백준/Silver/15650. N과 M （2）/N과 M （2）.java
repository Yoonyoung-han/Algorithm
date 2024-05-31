import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 --------------------------------------------------
 * 백트래킹, 재귀 문제다.
 *  N개중 M개 수열 출력 (중복X)
 * (1 ≤ M ≤ N ≤ 8)
 --------------------------------------------------
 */

public class Main {
    private static void makeCombi(int N, int M, int start, int depth, int[] combi) {
        // 재귀 끝 조건, 길이가 M인 것
        if (depth == M) {
            // 조합을 출력
            for (int i = 0; i < M; i++) {
                System.out.print(combi[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            combi[depth] = i;  // combi 배열의 현재 깊이에 i 값을 넣는다
            makeCombi(N, M, i + 1, depth + 1, combi);  // 다음 숫자를 추가하기 위해 재귀 호출
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = numList[0];
        int M = numList[1];

        makeCombi(N, M, 1, 0, new int[M]);

        br.close();
    }
}
