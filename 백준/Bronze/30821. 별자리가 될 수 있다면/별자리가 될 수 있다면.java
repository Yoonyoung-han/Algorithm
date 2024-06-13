import java.io.*;
import java.util.stream.IntStream;
/*
* 문제 해석
* 정N각형의 꼭짓점을 이어 만들 수 있는 별 개수
* 다섯 꼭짓점을 이어 붙인 것 = 별
*
* 해결 법
* N 중 5개 고르기
* 조합 문제
* */

public class Main {
    static int CNT;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numList = IntStream.range(0,N).toArray();
        boolean[] visted = new boolean[N];

        findCombination(numList,visted,0,N,5);

        bw.write(CNT+"\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

    private static void findCombination(
            int[] arr,
            boolean[] visited,
            int start,
            int n,
            int r
    ){
        if (r==0){
            CNT++;
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            findCombination(arr,visited,i+1,n,r-1);
            // 인덱스 선택하지 않은 경우
            visited[i] = false;
        }
    }

}


