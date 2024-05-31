import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/**
 --------------------------------------------------
 * 연산 문제다.
 * 조건에 따른 결과 불리언으로 반환
 * n0 이상의 범위에서 a1 * n + a0 <= c * n 조건 만족하는지 체크
 --------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] aList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a1 = aList[0];
        int a0 = aList[1];
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        // O(n) 정의를 만족하는지 확인
        // n0 이상의 범위에서 a1 * n + a0 <= c * n 조건 만족하는지 체크
        boolean result = IntStream.range(n0,101)
                            .allMatch(n -> a1 * n + a0 <= c * n);

        // 결과 출력
        System.out.println(result ? 1 : 0);
    }
}
