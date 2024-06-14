import java.io.*;
import java.util.Arrays;
/*
* 문제 해석
* 딸기우유 -> 초코우유 -> 바나나우유 -> 딸기우유
* 가게 별로 1종류만 팔음
* 마실 수 있는 우유 최대 개수
*
* 해결 법
* 영학 우유 순서 변수 필요 cnt%3 0 -> 1 -> 2
* 영학 우유 순서 == 가게 맞으면 drink cnt++
* */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 봉우리이자 활잡이 수
        int[] stores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] yh = {0,1,2};

        int drinkCnt = 0;
        int yhCnt = 0;
        for (int i = 0; i < N; i++) {
            if (yh[yhCnt%3]== stores[i]){
                drinkCnt++;
                yhCnt++;
            }
        }


        bw.write(drinkCnt+"\n");


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}


