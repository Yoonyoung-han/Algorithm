import java.io.*;
import java.util.*;

/*
* 별찍기 반복문
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        // 별 첫줄 초기화
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(N));
        bw.write(sb+"\n");

        // 시간복잡도 O(N)으로 만들기 위해 replace 사용
        for (int i = 0; i < N; i++) {
            sb.replace(i,i+1," ");
            bw.write(sb+"\n");
        }

        bw.flush();
        bw.close();
    }
}
