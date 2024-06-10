import java.io.*;
import java.util.*;

/*
* DFS 문제
* 무방향 그래프
* */

public class Main {
    static int rel = -1;
    static int cnt;
    static int[] isVisited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 정점 수
        String[] targets = br.readLine().split(" "); // 촌수 계산할 간선 정보
        int start = Integer.parseInt(targets[0]);
        int end = Integer.parseInt(targets[1]);
        int M = Integer.parseInt(br.readLine()); // 간선 수

        isVisited = new int[N+1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가
        for (int i = 1; i <= M; i++) {
            String[] edge = br.readLine().split(" ");
            int x = Integer.parseInt(edge[0]);
            int y = Integer.parseInt(edge[1]);

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        cnt = 0;
        dfs(start, end);

        bw.write(rel+"\n");

        bw.flush();
        bw.close();
    }

    private static void dfs(int node, int end){
        isVisited[node] = 1;

        if (node == end) {
            rel = cnt;
            return;
        }

        for (int newNode : graph.get(node)) {
            if (isVisited[newNode] == 0) {
                cnt++;
                dfs(newNode, end);
                cnt--; // 깊이 유지
            }
            if (rel != -1) { // rel이 갱신되면 탐색 종료
                return;
            }
        }

    }


}
