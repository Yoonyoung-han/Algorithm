import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 문자열 문제
* 문자열 숫자로 치환 후 더하기
* 소수 판별
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 단어 더하기
        int sum = 0;
        String target = br.readLine();
        for (int i = 0; i < target.length(); i++) {
            Character c = target.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sum += c - 'a' + 1; // 소문자 처리: 'a' -> 1, 'b' -> 2, ..., 'z' -> 26
            } else {
                sum += c - 'A' + 27; // 대문자 처리: 'A' -> 27, 'B' -> 28, ..., 'Z' -> 52
            }
        }

        // 삼항으로 치환, 출력
        System.out.println(isPrime(sum) ? "It is a prime word." : "It is not a prime word.");

        br.close();
    }

    // 소수 판별 메서드
    private static boolean isPrime(int number) {
        // 2부터 루트n까지 소수 판별
        for (int i = 2; i <= Math.sqrt(number); i++) {
            // 나눠 떨어지면 아님
            if (number % i == 0) return false;
        }
        return true;
    }

}
