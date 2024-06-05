import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
* 문자열 문제
* Collections.reverse(list) 이용
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            // 띄어쓰기로 끊어주고
            ArrayList<String> strings = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
            // 문자열 배열 뒤집고
            Collections.reverse(strings);
            // 다시 합치기
            String reversedString = String.join(" ", strings);
            // 출력
            System.out.println("Case #"+i +": "+ reversedString);
        }
    }
}
