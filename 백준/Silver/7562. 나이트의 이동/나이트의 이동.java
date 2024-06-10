import java.io.*;
import java.util.*;

/*
* 최단거리, bfs
* 나이트가 이동할 수 있는 8방향을 dx,dy로 지정
* 배열 크기에 맞게 visited 선언, 방문체크
* 나이트가 이동할 수 있는 경우마다 이동한 횟수를 +1
* */

public class Main {
    static int boardSize;
    static int[][] graph;
    static boolean[][] isVisited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    static int currX, currY;
    static int desX, desY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수

        for (int i = 0; i < testCase; i++) {
            boardSize = Integer.parseInt(br.readLine()); // 체스판 한변의 길이
            // 변수 초기화
            graph = new int[boardSize][boardSize];
            isVisited = new boolean[boardSize][boardSize];

            String[] currInput = br.readLine().split(" "); // 현재 칸
            currX = Integer.parseInt(currInput[0]);
            currY = Integer.parseInt(currInput[1]);

            String[] targetInput = br.readLine().split(" "); // 이동할 칸
            desX = Integer.parseInt(targetInput[0]);
            desY = Integer.parseInt(targetInput[1]);

            isVisited[currX][currY] = true; // 지금 칸 방문 true
            bfs(currX,currY);

            bw.write(graph[desX][desY] +"\n");

        }
        bw.flush();
        bw.close();
    }

    private static void bfs(int x,int y){

        // 큐에 추가
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            // 큐에서 빼서 체크
            int[] currNode = queue.poll();
            int currX = currNode[0];
            int currY = currNode[1];

            // 8 방향 탐색
            for (int i = 0; i < 8; i++) {
                // 이동 값
                int mX = currX + dx[i];
                int mY = currY + dy[i];

                // 범위값 체크
                if (mX < 0 || mX >= boardSize || mY < 0 || mY >= boardSize || isVisited[mX][mY] || graph[mX][mY] != 0){
                    continue;
                }

                // 방문 체크
                isVisited[mX][mY] = true;
                // 이동 값 = 현재 노드 이동 값 + 1
                graph[mX][mY] = graph[currX][currY] + 1;


                queue.add(new int[]{mX,mY});
            }
            
        }

    }


}
