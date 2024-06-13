import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/*
* 문제 해석
* n 중에 k개 골라서 만들 수 있는 정수 가짓수
*
* 해결 법
* N 중 K개 골라서 조합 생성 - 순서 중요 => 순열
* HashSet insert
* HashSet size 출력
* */

public class Main {
    static HashSet<String> NUMBERS = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        boolean[] visted = new boolean[N];

        String[] numberList = new String[N];

        for (int i = 0; i < N; i++) {
            numberList[i]=br.readLine();
        }

        findCombination(numberList,visted,new StringBuilder(),N,K);

        bw.write(NUMBERS.size()+"\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

    private static void findCombination(
            String[] arr,
            boolean[] visited,
            StringBuilder str,
            int n,
            int k
    ){
        if (k==0){
            NUMBERS.add(String.valueOf(str));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                visited[i] = true;
                str.append(arr[i]); // 현재 숫자를 추가
                findCombination(arr, visited, str, n, k-1);

                // 추가된 문자열 삭제
                str.delete(str.length() - arr[i].length(),str.length());
                // 해당 인덱스를 선택하지 않는 경우
                visited[i] = false;
            }
        }
    }

}


