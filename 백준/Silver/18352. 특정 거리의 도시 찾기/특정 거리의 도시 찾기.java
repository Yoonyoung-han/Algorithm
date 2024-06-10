import java.io.*;
import java.util.*;

/*
* 최단거리, bfs, 단방향
* 특정 최단거리 수를 만족하는 노드의 번호 출력
* */

public class Main {
    static ArrayList<Integer> result = new ArrayList<>();
    static int[] distances;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 도시의 개수 ( 정점 )
        int M = Integer.parseInt(input[1]); // 도로의 개수 ( 간선 )
        int K = Integer.parseInt(input[2]); // 거리 정보 ( 타겟 이동 수 )
        int X = Integer.parseInt(input[3]); // 출발 노드

        distances = new int[N + 1];
        Arrays.fill(distances, -1);
        isVisited = new boolean[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 연결
        for (int i = 0; i < M; i++) {
            int[] city = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(city[0]).add(city[1]);
        }

        bfs(X,K);

        Collections.sort(result);

        if (result.isEmpty()) {
            bw.write("-1\n");
        } else {
            for (int num : result) {
                bw.write(num + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void bfs(int start, int target){
        isVisited[start] = true;
        // 거리 초기화
        distances[start] = 0;

        // 큐에 추가
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            // 큐에서 빼서 체크
            int currNode = queue.poll();

            for (int newNode : graph.get(currNode)){
                if (!isVisited[newNode]) {
                    // 방문
                    isVisited[newNode] = true;
                    // 현재 노드 방문 cnt +1
                    distances[newNode] = distances[currNode] + 1;
                    // 거리가 맞으면 result에 추가
                    if (distances[newNode] == target){
                        result.add(newNode);
                    }else {
                        queue.add(newNode);
                    }
                }
            }
        }

    }
}
