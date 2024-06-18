import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
* 문제 해석
* a -> b 의존하면 b가 감염되면 a도 감염
* 의존 하지 않으면 a가 감염되어도 b는 감염X
* 총 감염된 컴퓨터 수, 마지막 컴퓨터가 감염되기까지 걸리는 시간
*
* 해결 법
* 컴퓨터 클래스 선언
* 본인 idx, 시간
* 다익스트라 -> 최단경로 최단시간 계산
* */

public class Main {
    // 감염 컴퓨터 수, 걸리는 시간 세기
    static int CNT, TOTALTIME = 0;

    public static class Node {
        int idx, time;
        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // testcase 개수

        for (int i = 0; i < T; i++) {
            int[] intput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = intput[0]; // 컴퓨터 개수 n
            int d = intput[1]; // 의존성 개수 d
            int c = intput[2]; // 해킹당한 컴퓨터 번호 -> start

            ArrayList<ArrayList<Node>> adj = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                adj.add(new ArrayList<>());
            }

            for (int j = 0; j < d; j++) {
                int[] dependency = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                adj.get(dependency[1]).add(new Node(dependency[0], dependency[2]));
            }

            dijkstra(n, c, adj);

            bw.write(CNT + " " + TOTALTIME + "\n");

        }

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


    private static void dijkstra(int n, int start, ArrayList<ArrayList<Node>> adj) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentIndex = current.idx;
            int currentTime = current.time;

            if (currentTime > dist[currentIndex]) continue;

            for (Node neighbor : adj.get(currentIndex)) {
                int newTime = currentTime + neighbor.time;
                if (newTime < dist[neighbor.idx]) {
                    dist[neighbor.idx] = newTime;
                    pq.offer(new Node(neighbor.idx, newTime));
                }
            }
        }

        CNT = 0;
        TOTALTIME = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                CNT++;
                TOTALTIME = Math.max(TOTALTIME, dist[i]);
            }
        }
    }


}



