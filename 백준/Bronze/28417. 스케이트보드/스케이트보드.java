import java.io.*;
import java.util.Arrays;
import java.util.Collections;


/*
* 정렬 문제
* 사칙 연산
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int maxScore = 0;

        for (int i = 0; i < N; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int score = checkMaxScore(inputs[0],inputs[1]) + sumTricks(Arrays.copyOfRange(inputs,2,7));
            if (score > maxScore){
                maxScore = score;
            }
        }

        bw.write(maxScore+"\n");

        bw.flush();
        bw.close();
    }

    private static int sumTricks (int[] trickScores){
        return Arrays.stream(Arrays.copyOfRange(Arrays.stream(trickScores).sorted().toArray(),3,5)).sum();
    }

    private static int checkMaxScore(int s1, int s2){
        return Math.max(s1,s2);
    }
}
