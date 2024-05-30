import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 --------------------------------------------------
 * 수학, 사칙 연산 문제다.
 * 배열 생성 후 stream으로 최댓값 구하고, avg 구하기
 --------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] intArr = new Integer[Integer.parseInt(st.nextToken())];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        // 최댓값
        int maxScore = Arrays.stream(intArr).max(Integer::compare).get();;

        // 새로운 점수로 변환하고 평균 계산
        double avg = Arrays.stream(intArr)
                .mapToDouble(score -> (double) score / maxScore * 100)
                .average()
                .getAsDouble();

        System.out.println(avg);

    }
}
