import java.io.*;
import java.util.Arrays;

/*
* 문제 해석
* 주어지는 수 5개 중 3개로 나눠지는 최소 자연수
*
* 해결 법
* 5개중 3개의 최소 공배수 중 최솟값 -> 조합
* 최소 공배수 : (a * b)/ 최대공약수
* a,b 최소 공배수를 구하고, 이거랑 c와의 최소공배수 구하기
* */

public class Main {

    private static int minVal = Integer.MAX_VALUE;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean[] visited = new boolean[5];
        combination(visited, 0, 5, 3);

        bw.write(minVal + "\n");


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

    // 조합 생성 (백트래킹)
    public static void combination(boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            calculateLCM(visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 선택된 조합의 최소공배수 계산
    public static void calculateLCM(boolean[] visited, int n) {
        int[] selected = new int[3];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                selected[index++] = numbers[i];
            }
        }

        int lcm = getLCM(selected[0], getLCM(selected[1], selected[2]));
        minVal = Math.min(minVal, lcm);
    }


    // 두 수의 최소공배수 구하기
    public static int getLCM(int num1, int num2) {
        return (num1 * num2) / getGCD(num1, num2);
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }


}



