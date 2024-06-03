import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 --------------------------------------------------
 * 배열 문제, 브루트포스
 * 모든 가능한 정사각형 크기 중에 꼭짓점 비교
 * 최대 크기 저장
 --------------------------------------------------
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // N 줄
        int M = Integer.parseInt(firstLine[1]); // M 개

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int maxSize = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
             // 가능한 최대의 정사각형 탐색
                for (int k = 1;( i + k < N ) && ( j + k < M); k++) {
                    // 꼭짓점 값 비교
                    if (board[i][j] == board[i][j + k] &&
                            board[i][j] == board[i + k][j] &&
                            board[i][j] == board[i + k][j + k]) {
                        // 최댓값 구하기
                        maxSize = Math.max(maxSize, k + 1);
                    }
                }
            }
        }

        System.out.println(maxSize*maxSize);
        br.close();
    }

}