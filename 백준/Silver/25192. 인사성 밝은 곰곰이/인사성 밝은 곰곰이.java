import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 --------------------------------------------------
 * 해시셋 문제다
 * ENTER 이후에 들어온 닉네임 중복X count
 * 닉네임 들어있는 해시셋 자료구조 생성
 * ENTER 또 나오면 해시셋 clear
 --------------------------------------------------
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> nameSet = new HashSet<>();
        int totalSum = 0;

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            if (name.equals("ENTER")){
                totalSum += nameSet.size();
                nameSet.clear();
            }else {
                nameSet.add(name);
            }
        }

        System.out.println(totalSum+nameSet.size());
        br.close();
    }
}