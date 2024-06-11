import java.io.*;
import java.util.*;

/*
* 용량 큰 순서대로 계속 더함
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 데이터

        for (int i = 0; i < T; i++) {
            long totalCost = 0;
            PriorityQueue<Long> chapters = new PriorityQueue<>();
            long K = Long.parseLong(br.readLine()); // 소설 챕터수
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < K; j++) {
                chapters.add(Long.parseLong(input[j]));
            }

            while (chapters.size()>1){
                long first = chapters.poll();
                long second = chapters.poll();
                long merged = first + second;
                totalCost += merged;
                // 계속 더함
                chapters.add(merged);
            }

            bw.write(totalCost+"\n");
        }

        bw.flush();
        bw.close();
    }


}
