import java.io.*;
import java.util.*;

/*
* 오름 차순 정렬
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        // 최소 대기시간 계산
        int totalWaitTime = 0;
        int currentWaitTime = 0;
        for (int i = 0; i < N ; i++) {
            currentWaitTime += people[i];
            totalWaitTime += currentWaitTime;
        }

        bw.write(totalWaitTime + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
