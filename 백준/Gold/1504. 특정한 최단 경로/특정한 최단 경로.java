import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int index; // 정점번호
        int cost; // 가중치

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        // cost(=가중치) 중심으로 우선순위가 정해지기 때문에 compareTo 오버라이딩
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 정점의 개수
        int E = Integer.parseInt(input[1]); // 간선의 개수

        // 정점 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 초기화
        for (int i = 0; i < E; i++) {
            int[] vertexInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = vertexInfo[0];
            int b = vertexInfo[1];
            int cost = vertexInfo[2];

            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        int[] crossEdges = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v1 = crossEdges[0];
        int v2 = crossEdges[1];

        // 1->v1->v2->N 경로와 1->v2->v1->N 경로의 최단 거리 계산
        int path1 = calculatePath(N, 1, v1, v2, N);
        int path2 = calculatePath(N, 1, v2, v1, N);

        int result = Math.min(path1, path2);

        if (result >= Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            bw.write(result + "\n");
        }

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }

    public static int calculatePath(int N, int start, int mid1, int mid2, int end) {
        int dist1 = dijkstra(N, start, mid1);
        int dist2 = dijkstra(N, mid1, mid2);
        int dist3 = dijkstra(N, mid2, end);

        if (dist1 == Integer.MAX_VALUE || dist2 == Integer.MAX_VALUE || dist3 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return dist1 + dist2 + dist3;
    }

    // 다익스트라 알고리즘
    public static int dijkstra(int n, int start, int end) {
        // 방문 계산
        boolean[] check = new boolean[n + 1];
        // 거리 계산
        int[] dist = new int[n + 1];

        // 무한대 값으로 초기화
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        // 출발지 거리는 0
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int currNode = pq.poll().index;

            if (check[currNode]) continue;
            check[currNode] = true;

            // 정점 비교
            for (Node next : graph.get(currNode)) {
                // 지금까지 출발지에서 갈 때 가장 빠른 거리 > 출발지에서 지금 노드 방문하고 next 가는 거리
                if (dist[next.index] > dist[currNode] + next.cost) {
                    // 값 갱신
                    dist[next.index] = dist[currNode] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist[end];
    }
}
