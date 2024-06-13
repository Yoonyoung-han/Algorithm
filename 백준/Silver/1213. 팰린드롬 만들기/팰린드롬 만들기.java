import java.io.*;
import java.util.TreeMap;


/*
* 문제 해석
* 팰린드롬 만들기 -> 토마토, 장발장
*
* 해결 법
* TreeMap 알파벳 : 개수 으로 집계
* 문자 전체 길이 짝수 -> 다 2의 배수
* 문자 전체 길이 홀수 -> 한쌍만 빼고 다 2의 배수
* 원소들 유효성 체크 -> 안되면 I'm Sorry Hansoo 출력
* 채우고 난 다음에는 map에서 갯수 뺌
* 전체 길이 짝수 -> 사전순 대로 전체 개수/2 , reverse해서 붙이기
* 전체 길이 홀수 -> 사전순 대로 전체 개수/2 , reverse해서 붙이기, 가운데 인덱스에 홀수 알파벳 채우기
* */

public class Main {

    static boolean ODD = true; // 홀수판별

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        StringBuilder result = new StringBuilder();

        String[] input = br.readLine().split("");
        int N = input.length;

        // TreeMap 알파벳 : 개수 으로 집계
        for (String alpha : input) {
            treeMap.put(alpha,treeMap.getOrDefault(alpha,0)+1);
        }

        if (isValid(treeMap,N)){
            StringBuilder half = new StringBuilder();
            String mid = "";

            for (String key : treeMap.keySet()) {
                int count = treeMap.get(key);
                // 홀수인 경우
                if (count % 2 == 1) {
                    mid = key; // 가운데 문자 저장
                    count--;
                }
                // 절반만 추가
                for (int i = 0; i < count / 2; i++) {
                    half.append(key);
                }
            }

            result.append(half); // 절반 추가
            result.append(mid); // 가운데 문자 추가 (홀수인 경우)
            result.append(half.reverse()); // 절반을 반대로 추가

            bw.write(result + "\n");

        }else {
            bw.write("I'm Sorry Hansoo\n");
        }

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

    private static boolean isValid(TreeMap<String, Integer> treeMap, int N){
        boolean check = true;

        int oddCnt = 0;
        // 짝수
        if (N%2 ==0){
            ODD = false;
        }

        for (String key:treeMap.keySet()) {
            if ((!ODD && treeMap.get(key)%2 !=0 ) || ODD && oddCnt > 1){
                check = false;
                break;
            }else if(ODD && treeMap.get(key)%2 ==1){
                oddCnt++;
            }
        }

        return check;
    }


}


