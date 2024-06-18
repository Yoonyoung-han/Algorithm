import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 문제 해석
* 대포로 발사 되면 50m이동 가능 -> 빠름 2초 걸림 25m/s
* 걸어가기 -> 5m/s
* 최단 경로의 소요 시간 구하기
*
* 해결 법
* 다익스트라로 풀기
* x,y 좌표
* 각 위치의 좌표와 이동 시간을 고려하여 최단 시간 계산
* */

public class Main {
    // 위치를 나타내는 클래스
    public static class Position {
        double x, y;
        public Position(double x, double y) {
            this.x = x;
            this.y = y;
        }
        // 다른 위치와의 거리 계산
        public double distanceTo(Position p) {
            return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double[] startCoords = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double[] endCoords = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();


        Position start = new Position(startCoords[0], startCoords[1]);
        Position end = new Position(endCoords[0], endCoords[1]);

        // 대포의 수 입력
        int n = Integer.parseInt(br.readLine());
        Position[] cannons = new Position[n + 2];
        cannons[0] = start;
        cannons[n + 1] = end;

        // 대포 위치 입력
        for (int i = 1; i <= n; i++) {
            String[] cannonCoords = br.readLine().split(" ");
            cannons[i] = new Position(Double.parseDouble(cannonCoords[0]), Double.parseDouble(cannonCoords[1]));
        }

        // 최단 시간 배열 초기화
        double[] minTime = new double[n + 2];
        Arrays.fill(minTime, Double.MAX_VALUE);
        minTime[0] = 0;

        // 우선순위 큐를 이용한 다익스트라 알고리즘
        PriorityQueue<Position> pq = new PriorityQueue<>(Comparator.comparingDouble(p -> minTime[Arrays.asList(cannons).indexOf(p)]));
        pq.add(start);

        while (!pq.isEmpty()) {
            Position current = pq.poll();
            int currentIndex = Arrays.asList(cannons).indexOf(current);
            double currentTime = minTime[currentIndex];

            for (int i = 0; i < n + 2; i++) {
                if (i == currentIndex) continue;
                Position next = cannons[i];
                double timeToNext;
                if (currentIndex == 0) {
                    // 시작점에서 다음 위치까지 걷기
                    timeToNext = current.distanceTo(next) / 5.0;
                } else {
                    // 대포로 이동하거나 걷기
                    double walkTime = current.distanceTo(next) / 5.0;
                    double cannonTime = Math.abs(current.distanceTo(next) - 50) / 5.0 + 2.0;
                    timeToNext = Math.min(walkTime, cannonTime);
                }

                // 최단 시간 갱신
                if (currentTime + timeToNext < minTime[i]) {
                    minTime[i] = currentTime + timeToNext;
                    pq.add(next);
                }
            }
        }

        // 최단 시간 출력
        bw.write(String.format("%.6f\n", minTime[n + 1]));


        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}



