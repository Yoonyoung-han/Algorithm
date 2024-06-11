import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
* 우선순위 큐에 넣고 하나씩 빼면서 cnt++
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // N
        int dasom = Integer.parseInt(br.readLine()); // 다솜 득표수

        PriorityQueue<Integer> votes = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < N; i++) {
            int curr = Integer.parseInt(br.readLine());
            votes.add(curr);
        }

        int result = 0;
        while (!votes.isEmpty()){
            int curr = votes.poll();
            // dasom 보다 크면 하나 빼서 넣어주기
            if (curr >= dasom){
                dasom++;
                curr--;
                result++;
                votes.add(curr);
            }
        }

        bw.write(result+"\n");


        bw.flush();
        bw.close();
    }


}
