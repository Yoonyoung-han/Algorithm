import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 --------------------------------------------------
 *
 --------------------------------------------------
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchNum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 스위치 배열
        int[] switches = new int[switchNum];
        for (int i = 0; i < switchNum; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (sex == 1) { // 남학생
                for (int j = number; j <= switchNum; j += number) {
                    switches[j - 1] = 1 - switches[j - 1];
                }
            } else { // 여학생
                int index = number - 1;
                int left = index, right = index;

                while (left > 0 && right < switchNum - 1 && switches[left - 1] == switches[right + 1]) {
                    left--;
                    right++;
                }
                for (int j = left; j <= right; j++) {
                    switches[j] = 1 - switches[j];
                }
            }
        }

        br.close();

        // 결과 출력 (20개씩 줄바꿈)
        for (int i = 0; i < switchNum; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
        // 마지막 줄바꿈
        if (switchNum % 20 != 0) {
            System.out.println();
        }
    }

}
