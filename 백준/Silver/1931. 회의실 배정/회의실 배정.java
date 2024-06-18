import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
* 문제 해석
* N개의 회의에 대한 회의실 사용표
* 최대 사용할 수 있는 회의의 최댓값
*
* 해결 법
* 최대한 짧게 이용하는 회의가 굳
* 종료시간 기준 정렬 -> 가장 빠른 회의가 첫번째
* 종료 시간 - 시작시간 안겹치는 회의로 cnt++
* */

public class Main {
    public static class Node{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 회의 수
        ArrayList<Node> meetings = new ArrayList<>();

        // 회의 정보 입력 받기
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meetings.add(new Node(input[0], input[1]));
        }

        // 종료 시간 기준으로 회의 정렬 (종료 시간이 같으면 시작 시간으로 정렬)
        meetings.sort(Comparator.comparingInt((Node node) -> node.end).thenComparingInt(node -> node.start));

        // 최대 중첩되지 않는 회의 수 구하기
        int maxMeetings = 0;
        int currentEnd = 0;

        for (Node meeting : meetings) {
            if (meeting.start >= currentEnd) {
                // 이 회의에 참석 가능
                maxMeetings++;
                currentEnd = meeting.end;
            }
        }

        // 결과 출력
        bw.write(maxMeetings+"\n");

        // 출력 버퍼 비우기
        bw.flush();

        // 리소스 닫기
        bw.close();
        br.close();
    }


}



