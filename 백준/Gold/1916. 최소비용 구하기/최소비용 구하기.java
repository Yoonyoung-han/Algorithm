import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 문제 해석
* A -> B 도시까지 가는데 드는 버스 최소 비용
*
* 해결 법
* 다익스트라
* 버스 노드 클래스 만들기
* */

public class Main {
    public static class Node implements Comparable<Node> {
        int city;
        int cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] busInfo = br.readLine().split(" ");
            int start = Integer.parseInt(busInfo[0]);
            int end = Integer.parseInt(busInfo[1]);
            int cost = Integer.parseInt(busInfo[2]);
            graph.get(start).add(new Node(end, cost));
        }

        String[] query = br.readLine().split(" ");
        int startCity = Integer.parseInt(query[0]);
        int endCity = Integer.parseInt(query[1]);

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startCity] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startCity, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentCity = current.city;
            int currentCost = current.cost;

            if (currentCost > dist[currentCity]) continue;

            for (Node neighbor : graph.get(currentCity)) {
                int newCost = currentCost + neighbor.cost;
                if (newCost < dist[neighbor.city]) {
                    dist[neighbor.city] = newCost;
                    pq.add(new Node(neighbor.city, newCost));
                }
            }
        }

        bw.write(dist[endCity]+"\n");


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}



