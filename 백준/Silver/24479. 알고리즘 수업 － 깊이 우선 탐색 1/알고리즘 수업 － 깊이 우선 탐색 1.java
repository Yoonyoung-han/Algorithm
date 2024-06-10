import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

/*
* DFS 문제
* */

public class Main {
    // 방문 순서 기록
    static int order;
    static int[] isVisited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 정점 수
        int M = Integer.parseInt(s[1]); // 간선 수
        int R = Integer.parseInt(s[2]); // 시작 정점

        isVisited = new int[N+1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가
        for (int i = 1; i <= M; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        order = 1;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            bw.write(isVisited[i]+"\n");
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int node){

        isVisited[node] = order; // 방문 순서 기록

        for (int nextNode : graph.get(node)) {
            if (isVisited[nextNode] == 0) {
                order++;
                dfs(nextNode);
            }
        }
    }


}
