import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 --------------------------------------------------
 * 배열 원소 이동
 * 이동하는 라인만큼 회전
 --------------------------------------------------
 */
public class Main {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 아래, 오른쪽, 위, 왼쪽 -> 반시계방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());


        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = Math.min(N,M)/2; // 회전하는 라인의 수

        //회전
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < cnt; j++) { // 이동하는 라인 회전
                rotateArr(j,board,N,M);
            }
        }


        // 배열 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        br.close();
    }

    private static void rotateArr(int j, int[][] board,int N, int M) {
        int x = j, y = j;
        int d = 0; // 반시계 방향
        int temp = board[x][y]; // 이동하는 라인 시작 0,0 -> 1,1 ..

        while (d < 4) {

            int tmpx = x + dirs[d][0];
            int tmpy = y + dirs[d][1];

            if (tmpx >= j && tmpx < N - j && tmpy >= j && tmpy < M - j) { // 범위 안의 값일 때 치환
                int n = temp;
                temp = board[tmpx][tmpy];
                board[tmpx][tmpy] = n;

                x = tmpx;
                y = tmpy;
            }else {
                d++;
            }

        }

        board[j+1][j] = temp; // 다음 시작값 저장
    }

}
