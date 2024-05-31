import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 --------------------------------------------------
 * 교집합 구하는 문제다.
 * 듣X -> N
 * 보X -> M ( N+2부터 시작 -> 듣X 다음 보X 나옴)
 --------------------------------------------------
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();

        Map<String, Integer> checkDup = new HashMap<>();
        // 문자열 생성
        for (int i = 0; i < totalNum; i++) {
            String name = br.readLine();
            checkDup.put(name, checkDup.getOrDefault(name, 0) + 1);
        }

        List<String> intersection = checkDup.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(intersection.size());
        intersection.forEach(System.out::println);

        br.close();
    }
}

