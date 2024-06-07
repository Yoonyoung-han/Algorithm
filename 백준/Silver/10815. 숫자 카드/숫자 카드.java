import java.io.*;
import java.util.*;

/*
* 해시셋 사용
* 상근 카드 리스트에 있으면 1
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 상근이 숫자카드 개수
        int[] sangCard = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int M = Integer.parseInt(br.readLine()); // TEST 카드 개수
        int[] testCard = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> cardSet = new HashSet<>();

        for (int num : sangCard) {
            cardSet.add(num);
        }

        for (int num : testCard) {
            if (cardSet.contains(num)) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
