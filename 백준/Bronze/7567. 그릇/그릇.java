import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 짝이 맞으면 +10, 아니면 +5
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 처음 바닥 높이
        int sum = 10;
        String str = br.readLine();


        for (int i = 1; i < str.length(); i++) {
            // 같은 방향
            if (str.charAt(i) == str.charAt(i-1)){
                sum += 5;
            } else {
                sum += 10;
            }
        }

        System.out.println(sum);
    }
}
