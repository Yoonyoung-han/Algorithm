import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.PriorityQueue;
/*
* 문제 해석
* 주어진 단어를 삼등분
* 쪼개진 단어를 뒤집고 붙인 조합 중 사전순으로 가장 앞서는 단어 출력
*
* 해결 법
* 삼등분 가능한 모든 조합 구하기
* 문자열 뒤집고 합침
* 우선순위 큐에 넣음
* 제일 앞에거 빼서 출력
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String T = br.readLine();
        String result = findCombination(T);

        bw.write(result+"\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        br.close();
        bw.close();
    }


    private static String findCombination(String str){

        PriorityQueue<String> stringList = new PriorityQueue<>();

        int rotationNum = str.length();

        // 삼등분 할 수 있는 모든 경우의 수
        for (int i = 1; i < rotationNum-1; i++) {
            for (int j = i+1; j < rotationNum; j++) {

                String first = new StringBuilder(str.substring(0, i)).reverse().toString();
                String second = new StringBuilder(str.substring(i, j)).reverse().toString();
                String third = new StringBuilder(str.substring(j)).reverse().toString();

                String combined = first + second + third;
                stringList.add(combined);

            }
        }

        return stringList.peek();
    }
}
