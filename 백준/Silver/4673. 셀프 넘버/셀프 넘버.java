import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
/*
* 문제 해석
* 각 자리수를 더한 값 = d(n)
* n은 생성자 33은 39의 생성자 (33+3+3 = 39)
* 생성자가 없는 수 = 셀프 넘버
* 10000보다 작거나 같은 셀프 넘버를 한줄에 하나씩 출력
*
* 해결 법
* 10000보다 작거나 같은 각 자리수를 더한 값으로 수열 생성 dn
* 10으로 나누고 난 몫 -> 10의 자리 숫자 / 10으로 나누고 난 나머지 -> 1의 자리 숫자
* 10의 자리 숫자 다시 10으로 나누기-> 0되면 멈춤, 1의 자리 숫자만 더함
* 이 수열에 없는 수면 출력
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isNotSelfNumber = new boolean[10001]; // 1 ~ 10000의 생성자를 표시할 배열

        // 수열 생성
        for (int i = 1; i <= 10000; i++) {
            int n = d(i);
            if (n <10001){
                isNotSelfNumber[n] = true; // 생성자 있는 수 표시
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!isNotSelfNumber[i]) {
                bw.write(i + "\n"); // 셀프 넘버 출력
            }
        }


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
    }

    public static int d(int target){
        // 자기 자신 숫자로 초기화
        int sum = target;

        while(target != 0){
            sum = sum + (target % 10); // 첫 째 자리수
            target = target/10;
        }

        return sum;
    }

}
