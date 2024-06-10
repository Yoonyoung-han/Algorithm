import java.io.*;
import java.util.*;

/*
* 딸기, 바나나,라임,자두
* 5개 되면 YES, 아니면 NO
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 단어의 수
        HashMap<String, Integer> cards = new HashMap<>();
        cards.put("STRAWBERRY",0);
        cards.put("BANANA",0);
        cards.put("LIME",0);
        cards.put("PLUM",0);

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String fruit = input[0];
            int num = Integer.parseInt(input[1]);

            cards.put(fruit,cards.get(fruit)+num);
        }


        String result = cards.entrySet().stream().anyMatch(entry-> entry.getValue() == 5) ? "YES" : "NO";

        bw.write(result+"\n");

        bw.flush();
        bw.close();
    }

}
