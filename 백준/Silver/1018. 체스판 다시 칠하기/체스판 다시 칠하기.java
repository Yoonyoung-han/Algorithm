import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 --------------------------------------------------
 * 배열, 재귀 문제다
 * 패턴 매치 후 변경할 수 중 최솟값 구하기
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

        int minRepaint = Integer.MAX_VALUE;

        // 8x8 크기로 자를 수 있는 모든 부분 보드에 대해 확인
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minRepaint = Math.min(minRepaint, calculateRepaint(board, i, j));
            }
        }

        System.out.println(minRepaint);
        br.close();
    }

    private static int calculateRepaint(char[][] board, int startX, int startY) {
        String[] pattern1 = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"};
        String[] pattern2 = {"BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB"};

        int repaint1 = 0; // for pattern1
        int repaint2 = 0; // for pattern2

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[startX + i][startY + j] != pattern1[i].charAt(j)) {
                    repaint1++;
                }
                if (board[startX + i][startY + j] != pattern2[i].charAt(j)) {
                    repaint2++;
                }
            }
        }

        return Math.min(repaint1, repaint2);
    }
}
