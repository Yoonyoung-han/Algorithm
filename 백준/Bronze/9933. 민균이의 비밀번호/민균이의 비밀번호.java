import java.io.*;
import java.util.*;

/*
* 문자열 문제
* 뒤집은 문자열 일치 확인
* 맞으면 문자열 길이, 문자열길이/2 인덱스 출력
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 단어의 수
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        String result = null;
        for (int i = 0; i < N; i++) {
            String original = words.get(i);
            String reversed = new StringBuilder(original).reverse().toString();
            if (words.contains(reversed)) {
                result = original;
                break;
            }
        }

        if (result != null) {
            int length = result.length();
            int midIndex = (length / 2);
            bw.write(length + " " + result.charAt(midIndex) + "\n");
        }

        bw.flush();
        bw.close();
    }

}
