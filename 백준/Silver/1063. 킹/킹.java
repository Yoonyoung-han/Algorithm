import java.io.*;
import java.util.HashMap;
/*
* 문제 해석
* 열 = 알파벳 (A-H)
* 행 = 숫자 (1-8)
* 돌과 킹의 마지막 위치 출력
* 돌 위치와 겹치면 돌도 같은 방향으로 한칸 이동
*
* 해결 법
* x,y 좌표를 가진 point 객체 생성
* 방향에 맞게 킹 포인터 이동, 돌 포인터와 만나면 돌도 같이 이동 => 판을 벗어나면 이동 X
*
* */

public class Main {
    static class Pointer{
        int x; // 행
        int y; // 열

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            char col = (char) ('A' + x);
            int row = y + 1;
            return "" + col + row;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방향 생성
        HashMap<String, int[]> dir = new HashMap<>();
        dir.put("R", new int[]{1, 0}); // 오른쪽 이동
        dir.put("L", new int[]{-1, 0}); // 왼쪽 이동
        dir.put("B", new int[]{0, -1}); // 아래 이동
        dir.put("T", new int[]{0, 1}); // 위 이동
        dir.put("RT", new int[]{1, 1}); // 오른쪽 위 대각선
        dir.put("LT", new int[]{-1, 1}); // 왼쪽 위 대각선
        dir.put("RB", new int[]{1, -1}); // 오른쪽 아래 대각선
        dir.put("LB", new int[]{-1, -1}); // 왼쪽 아래 대각선

        String[] input = br.readLine().split(" ");
        Pointer king = convertToPointer(input[0]);
        Pointer rock = convertToPointer(input[1]);

        int N = Integer.parseInt(input[2]); // 돌아가는 횟수

        for (int i = 0; i < N; i++) {
            int[] dirs = dir.get(br.readLine());
            int newKingX = king.x + dirs[0];
            int newKingY = king.y + dirs[1];

            // 범위 값 안에 있는지 체크
            if (isValid(newKingX,newKingY)){
                // 이동할 값이 돌 좌표랑 같으면 돌도 유효값 체킹 & 위치 이동
                if (newKingX==rock.x&& newKingY==rock.y){
                    int newRockX = rock.x+ dirs[0];
                    int newRockY = rock.y + dirs[1];
                    if (isValid(newRockX, newRockY)){
                        rock.x = newRockX;
                        rock.y = newRockY;
                        king.x = newKingX;
                        king.y = newKingY;
                    }
                }else { // 아니면 왕만 이동
                    king.x = newKingX;
                    king.y = newKingY;
                }
            }
        }

        bw.write(king+"\n");
        bw.write(rock+"\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

    private static boolean isValid(int x,int y){
        return x >= 0 && x <=7 && y>=0 && y<=7;
    }

    private static Pointer convertToPointer(String str){
        int row = str.charAt(0) - 'A'; // 0부터 시작
        int col = str.charAt(1) - '1'; // 0부터 시작

        return new Pointer(row,col);
    }

}
