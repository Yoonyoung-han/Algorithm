import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 --------------------------------------------------
 * 문자열, 정렬, 맵 문제다
 * 파일 확장자 : 파일 갯수
 * 사전 순인 TreeMap 생성
 * String에서 "."기준으로 split, 키 값이 같은 것에 ++
 --------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 사전 순 TreeMap 객체 생성
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String ext = br.readLine().split("\\.")[1];
            // 맵에 존재하지 않으면 추가, 존재하면 val++
            if(treeMap.get(ext)==null){
                treeMap.put(ext,1);
            }else {
                treeMap.put(ext,treeMap.get(ext)+1);
            }
        }
        treeMap.forEach((key,value)->{
            System.out.println(key+" "+value);
        });
    }
}
