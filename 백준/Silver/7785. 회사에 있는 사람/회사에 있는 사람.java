import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 --------------------------------------------------
 * 해시 맵으로 자료구조를 만든다
 * 이름 : 출입 기록
 * 사전의 역전 순인 TreeMap 생성
 * leave인 사람은 삭제
 --------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // 사전 역순의 TreeMap 객체 생성
        TreeMap<String, String> sh = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            sh.put(name,status);
            // 회사 있는 사람만 map에 put
            if (status.equals("leave")){
                sh.remove(name);
            }
        }

        sh.forEach((key,value)->{
            System.out.println(key);
        });

    }
}