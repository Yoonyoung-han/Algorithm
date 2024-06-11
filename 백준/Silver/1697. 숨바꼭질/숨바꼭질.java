import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/*
* BFS, 단방향
* */

public class Main {
    static int[] isVisited;
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 수빈 위치
        int K = Integer.parseInt(input[1]); // 동생 위치

        if (N == K) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            return;
        }

        isVisited = new int[MAX];
        Arrays.fill(isVisited, -1);

        int result = bfs(N, K);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static int bfs(int N, int target){
        //큐에 추가
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        isVisited[N] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            int[] nextPositions = {curr + 1, curr - 1, curr * 2};

            for (int newNode : nextPositions) {
                if (newNode >= 0 && newNode < MAX && isVisited[newNode] == -1) {
                    isVisited[newNode] = isVisited[curr] + 1;
                    if (newNode == target) {
                        return isVisited[newNode];
                    }
                    queue.add(newNode);
                }
            }
        }

        return -1; // 온 적 없음
    }

}
