import java.io.*;

/*
* 문제 해석
* 거북이가 이동한 경로를 모두 포함하는 가장 작은 직사각형의 넓이 구하기
* 이동, 방향 값 있음
*
* 해결 법
* (maxX - minX) * (maxY - minY)
* 이동할 때마다 max값, min값 비교 후 업데이트
* 방향 -> 이동 연산 값 바꿔주기
* 이동 -> 현재 좌표 바꿔주기
* 총 네개의 이동 연산
* 위로 이동부터 시작 -> 오른쪽 90도 회전 -> 오른쪽 이동 -> 오른쪽 90도 회전 -> 아래 이동
* */

public class Main {

    // 방향을 나타내는 배열 (순서대로 북, 동, 남, 서)
    static int[] DX = {0, 1, 0, -1};
    static int[] DY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // testcase

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split("");
            // 현재 좌표
            int dirVal = 0; // 0: 북, 1: 동, 2: 남, 3: 서
            int currX = 0;
            int currY = 0;

            // 직사각형 계산용 좌표
            int maxX = 0;
            int maxY = 0;
            int minX = 0;
            int minY = 0;

            // 명령 수행 시작
            for (String command:input) {
                // 앞으로 가라
                if (command.equals("F")){
                    currX += DX[dirVal];
                    currY += DY[dirVal];
                } else if (command.equals("B")) { // 뒤로 가라
                    currX -= DX[dirVal];
                    currY -= DY[dirVal];
                } else if (command.equals("L")) { // 왼쪽으로 회전해라
                    dirVal = (dirVal + 3) % 4; // 왼쪽 회전

                }else if (command.equals("R")){ // 오른쪽으로 회전해라
                    dirVal = (dirVal + 1) % 4; // 오른쪽 회전
                }

                // 좌표 업데이트
                maxX = Math.max(maxX, currX);
                maxY = Math.max(maxY, currY);
                minX = Math.min(minX, currX);
                minY = Math.min(minY, currY);
            }
            bw.write((maxX - minX) * (maxY - minY) +"\n");
        }


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}


