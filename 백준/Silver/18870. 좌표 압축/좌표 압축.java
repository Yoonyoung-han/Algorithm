import java.io.*;
import java.util.*;

/*
* 좌표 압축
* 오름차순 정렬
* 중복 제거
* 중복제거된 배열의 index 값으로 계산
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 오름차순 정렬 & 중복제거
        int[] coordinate = Arrays.stream(inputs).sorted().distinct().toArray();

        // 좌표 압축을 위한 Map input 숫자 : 중복 제거된 배열에서 위치 값
        Map<Integer, Integer> compressedMap = new HashMap<>();
        int index = 0;

        for (int num : coordinate) {
            if (!compressedMap.containsKey(num)) {
                compressedMap.put(num, index++);
            }
        }

        // 결과 출력
        for (int num : inputs) {
            bw.write(compressedMap.get(num) + " ");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
