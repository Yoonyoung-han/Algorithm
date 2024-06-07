import java.io.*;
import java.util.*;

/*
* 9개 중 7개 합쳐서 100인 변수 골라내기
* 오름차순으로 출력
* 전체합 - 두 원소 = 100이 되는지 확인
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dwarfs = new int[9];
        int totalSum=0;

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            totalSum += dwarfs[i];
        }

        // 전체합 - 두 원소 = 100이 되는지 확인
        outer: for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (totalSum - dwarfs[i] -dwarfs[j] == 100){
                    // 음수로 치환
                    dwarfs[i] = -1;
                    dwarfs[j] = -1;
                    break outer;
                }
            }
        }
        // 오름차순 정렬
        Arrays.sort(dwarfs);
        // 출력
        for (int i = 2; i < 9; i++) {
            bw.write(dwarfs[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
