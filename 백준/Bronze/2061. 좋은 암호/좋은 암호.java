import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

/*
* 문제 해석
* 주어지는 수 K를 인수 분해 했을때 나오는 숫자들이
* L이상일 경우 GOOD
* 아니면 BAD 와
* 인수 분해한 숫자 중 가장 작은 수 출력 (1제외)
*
* 해결 법
* K가 L-1의 소인수 가지고 있는지 체크
* 나누어 지지 않으면 good
* 나누어 지면 bad + 작은수
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        BigInteger K = new BigInteger(input[0]);
        int L = Integer.parseInt(input[1]);

        String result = factorization(K,L);

        bw.write(result+"\n");


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        br.close();
        bw.close();
    }


    public static String factorization(BigInteger num,int baseLine) {

        // 2부터 L-1까지의 소수로 나누어 떨어지는지 확인
        for (int i = 2; i < baseLine; i++) {
            if (num.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                return "BAD " + i;
            }
        }

        return "GOOD";
    }
}
