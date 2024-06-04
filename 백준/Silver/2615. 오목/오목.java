import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 19;
    private static int[][] board = new int[SIZE][SIZE];
    private static final int[] dx = {0, 1, 1, -1};
    private static final int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != 0) {
                    int current = board[i][j];
                    for (int direction = 0; direction < 4; direction++) {
                        if (checkFiveInRow(i, j, current, direction)) {
                            System.out.println(current);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static boolean checkFiveInRow(int x, int y, int current, int direction) {
        int count = 1;

        int nx = x + dx[direction];
        int ny = y + dy[direction];
        while (isInBounds(nx, ny) && board[nx][ny] == current) {
            count++;
            nx += dx[direction];
            ny += dy[direction];
        }

        if (count == 5) {
            int prevX = x - dx[direction];
            int prevY = y - dy[direction];
            if (isInBounds(prevX, prevY) && board[prevX][prevY] == current) {
                return false;
            }
            return true;
        }

        return false;
    }

    private static boolean isInBounds(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }
}
