import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/*
* 이진 탐색
* 절단 길이 M과 비교
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] var = br.readLine().split(" ");
        int N = Integer.parseInt(var[0]);
        int M = Integer.parseInt(var[1]);

        int[] trees = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 이진 탐색을 위한 초기 값 설정
        int start = 0;
        int end = Arrays.stream(trees).max().getAsInt();
        int result = 0;

        // 이진 탐색
        while (start <= end) {
            int mid = (start + end) / 2;
            long total = 0;

            // 각 나무 높이에서 mid 높이로 자를 때 얻을 수 있는 나무 길이를 계산
            for (int tree : trees) {
                if (tree > mid) {
                    total += tree - mid;
                }
            }

            // 얻은 나무 길이가 필요한 길이 M 이상인지 확인
            if (total >= M) {
                result = mid;  // 조건을 만족하면 결과를 저장하고 더 높은 절단 높이를 탐색
                start = mid + 1;
            } else {
                end = mid - 1;  // 조건을 만족하지 않으면 더 낮은 절단 높이를 탐색
            }
        }


        bw.write(result+"\n");


        bw.flush();
        bw.close();
        br.close();
    }

}
