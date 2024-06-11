import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 최소힙 절대값
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> absHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs1 == abs2) {
                    // 같으면 제대로 비교
                    return Integer.compare(o1, o2);
                } else {
                    // 아니면 절대값 기준
                    return Integer.compare(abs1, abs2);
                }
            }
        });

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                absHeap.add(x);
            } else {
                if (absHeap.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(absHeap.poll() + "\n");
                }
            }
        }


        bw.flush();
        bw.close();
    }


}
