import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
* 덱을 이용해서 푼다
* 왼쪽 이동 : 맨 앞에거를 뒤로 보냄
* 오른쪽 이동 : 맨 뒤에거를 앞으로 보냄
* 뽑기 : 첫번째 원소
* 이동 연산수를 비교하고, 최솟값을 더해준다.
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 큐의 크기
        int M = Integer.parseInt(s[1]); // 뽑아내려는 갯수

        Deque<Integer> deq = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deq.addLast(i);
        }

        int[] targets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int totalOperations = 0;
        for (int target : targets) {
            int operations = pickNum(deq, target);
            totalOperations += operations;
        }

        System.out.println(totalOperations);
    }

    private static int pickNum(Deque<Integer> deq, int targetNum){
        int leftMoves = 0;
        int rightMoves = 0;

        for (int num : deq) {
            if (num == targetNum) {
                break;
            }
            leftMoves++;
        }

        // 오른쪽 이동은 어차피 왼쪽이동 나머지임
        rightMoves = deq.size() - leftMoves;

        // 둘 중 최솟값 구하고
        int operations = Math.min(leftMoves, rightMoves);

        //왼쪽이동
        if (operations == leftMoves) {
            for (int i = 0; i < leftMoves; i++) {
                deq.addLast(deq.removeFirst());
            }
            //  오른쪽 이동
        } else {
            for (int i = 0; i < rightMoves; i++) {
                deq.addFirst(deq.removeLast());
            }
        }

        // 첫번째 원소값 뽑기
        deq.removeFirst();
        return operations;

    }
}
