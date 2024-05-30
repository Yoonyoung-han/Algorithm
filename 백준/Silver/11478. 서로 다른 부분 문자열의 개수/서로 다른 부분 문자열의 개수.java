import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 --------------------------------------------------
 * 문자열 문제다
 * a-> b,a,b,c / b -> a,b,c .. 이므로 left,right 포인터를 둔다
 * left는 0으로 시작해서 반복문 돌면서 1씩 증가, right는 left+i -> i는 1부터 시작
 * 포인터를 하나씩 이동하면서 부분 문자열로 만들어준다.
 * 서로 다른 것의 개수를 세야하므로 중복제거를 위해 해쉬셋을 사용한다.
 --------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 중복제거를 위해 해쉬셋을 사용
        Set<String> set = new HashSet<>();
        
        //right 포인터 이동 반복
        for (int i = 1; i <= str.length(); i++) {
            // left 포인터 이동 반복
            for (int left=0, right= left+i; right <= str.length() ; left++,right++) {
                set.add(str.substring(left,right));
            }
        }
        
        System.out.println(set.size());
        br.close();
    }
}
