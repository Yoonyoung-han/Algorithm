import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/*
* x >0 -> 배열에 x 넣고
* x == 0 배열에서 가장 작은 값 출력, 그 값을 제거
* 배열 비어 있을 경우 0 출력
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> numList = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0){
                Integer min = numList.poll();
                if (min == null){
                    min = 0;
                }
                bw.write(min+"\n");
            }else {
                numList.add(x);
            }
        }


        bw.flush();
        bw.close();
    }

}
