import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/*
* 문제 해석
* n개의 트럭이 순차적으로 이동
* 다리 길이 w번 만큼 트럭이 이동해야 다리를 건너는 거임
* 다리 위에는 최대 하중 L 이하만 지나갈 수 있음
* 최단 시간을 구하라
*
* 해결 법
* 다리 큐 w길이 만큼 0 집어 넣음
* 다리 isEmpty 까지 반복 -> cnt++
* 현재 다리 무게 + 트럭 <= L 이면 트럭 -> bridge add 아니면 add 0
* */

public class Main {
    static int totalWeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 트럭 수
        int w = Integer.parseInt(input[1]); // 다리 길이
        int L = Integer.parseInt(input[2]); // 최대 하중

        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < w; i++) { //다리길이만큼 큐에 0 넣어줌
            bridge.add(0);
        }

        int[] trucks = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int time = 0;

        int idx = 0; // 트럭 배열 인덱스

        while (!bridge.isEmpty() && idx<n) { // idx 넘어 가지 X
            time++; // 시간 증가
            totalWeight -= bridge.poll(); // 다리에서 빠져나간 트럭의 무게를 totalWeight에서 빼준다.

            // 다리에 트럭이 추가되는 조건
            if (totalWeight + trucks[idx] <= L) {
                bridge.add(trucks[idx]); // 다리에 트럭 추가
                totalWeight += trucks[idx]; // 현재 다리 무게 증가
                idx++; // 다음 트럭으로 인덱스 이동
            }else {
                bridge.add(0);
            }
        }

        bw.write(time+bridge.size() + "\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}


