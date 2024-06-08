import java.io.*;


/*
* 수학 문제
* 수열 인덱스 1부터 시작
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int n = 0; // 반복 횟수 체크
        int sum = 0; // 범위내 누적합

        for (int i = 1; i <= B; i++) {
            for (int j = 1; j <=i; j++) { // i 만큼 반복
                n++;
                if (A<=n && n<=B){ // 범위 내면
                    sum += i;
                }
            }
        }


        bw.write(sum+"\n");

        bw.flush();
        bw.close();
    }
}
