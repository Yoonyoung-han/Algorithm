import java.io.*;
/*
* 문제 해석
* 청정 수열 : 길이가 2N, N까지의 수가 2번씩 나오는 수열
* 원소 i의 사이에 있는 수의 합 * i 의 총합이 최소값이 되는 개수
*
* 해결 법
* 최소값을 만족하려면 두 수가 붙어있으면 된다.
* N의 순열 개수만 구하면 끝 => N!
* */

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        bw.write(factorial(N)+"\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


    private static int factorial(int n){
        if (n==1){
            return 1;
        }
        return n*factorial(n-1);
    }


}


