import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* 큐에 큰 숫자가 먼저 나오도록 넣는다.
* index와 값을 갖고 있는 객체 사용
* */
public class Main {
    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    private static void printResult(Queue<Document> queue, int M){
        // 찾는 인덱스의 순서 출력
        int orderNum = 0;
        while (!queue.isEmpty()){
            Document curr = queue.poll();
            // 현재가 높은지 확인
            boolean isHigher = queue.stream().anyMatch(x -> x.priority > curr.priority);

            if (isHigher){
                // 높은 순서면 queue에 추가
                queue.add(curr);
            } else {
                orderNum++;
                if (curr.index == M){
                    System.out.println(orderNum);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]); // 문서의 수
            int M = Integer.parseInt(s[1]); // 궁금한 문서의 index

            Queue<Document> queue = new LinkedList<>();
            String[] test = br.readLine().split(" ");
            // 있는 순서 그대로 큐에 넣기
            for (int j = 0; j < N; j++) {
                queue.add(new Document(j,Integer.parseInt(test[j])));
            }
            printResult(queue,M);
        }
    }
}
