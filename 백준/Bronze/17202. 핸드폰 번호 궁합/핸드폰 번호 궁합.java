import java.io.*;
import java.util.Arrays;

/*
* 문제 해석
* 인접한 두수의 합의 1의 자리 숫자만 남김
* 2자리가 되었을 때의 값 출력
*
* 해결 법
* 두 수열을 겹쳐서 합친 배열 생성 dy[16]
* dy[i]+dy[i+1]%10 을 업데이트
* i의 반복 횟수는 15 -> 14 -> 13...2회까지 반복
* */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] A = br.readLine().split("");
        String[] B = br.readLine().split("");

        int[] nums = new int[16];

        for (int i = 0; i < 16; i++) {
            // 짝수는 A
            if (i%2 == 0){
                nums[i] = Integer.parseInt(A[i/2]);
            }else {
                nums[i] = Integer.parseInt(B[i/2]);
            }
        }

        // 인접한 두 수의 합의 1의 자리 숫자만 남기는 과정 반복, 최종 2회만 연산
        for (int i = 15; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }

        // 결과 출력
        bw.write(nums[0]+""+nums[1]);




        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}


