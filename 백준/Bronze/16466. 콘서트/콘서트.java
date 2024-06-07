import java.io.*;
import java.util.Arrays;

/*
* 주어진 배열 정렬
* 정렬 후 min값 비교하면서 값 업데이트
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] ticketSold = new int[N];
        String[] tickets = br.readLine().split(" ");
        int result = 1;

        for (int i = 0; i < N; i++) {
            ticketSold[i] = Integer.parseInt(tickets[i]);
        }

        Arrays.sort(ticketSold);
        // min값 비교하면서 값 업데이트
        for (int i = 0; i < N; i++) {
            if (ticketSold[i] == result){
                result++;
            }
        }

        bw.write(result+"\n");


        bw.flush();
        bw.close();
        br.close();
    }

}
