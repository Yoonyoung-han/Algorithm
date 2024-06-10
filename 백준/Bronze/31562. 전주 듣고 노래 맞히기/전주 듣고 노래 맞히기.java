import java.io.*;
import java.util.*;

/*
* 앞의 세개 문자열 같은게 1개면 노래제목
* 2개면 ?, 없으면 !
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 아는 노래 개수
        int M = Integer.parseInt(input[1]); // 맞히기 시도할 노래개수

        HashMap<String, StringBuilder> songs = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] songInfo = br.readLine().split(" ");

            Integer.parseInt(songInfo[0]);

            String title = songInfo[1];
            String[] strings = Arrays.copyOfRange(songInfo, 2, 5);
            StringBuilder combinedString = new StringBuilder();
            for (String s : strings) {
                combinedString.append(s).append(" ");
            }
            songs.put(title, combinedString);
        }

        for (int i = 0; i < M; i++) {
            String target = br.readLine();

            int matchCount = 0;
            String matchedTitle = "";

            // 각 노래의 앞 세 개 문자열과 비교
            for (Map.Entry<String, StringBuilder> entry : songs.entrySet()) {
                if (entry.getValue().toString().trim().equals(target)) {
                    matchCount++;
                    matchedTitle = entry.getKey();
                }
            }

            if (matchCount == 1) {
                bw.write(matchedTitle + "\n");
            } else if (matchCount > 1) {
                bw.write("?\n");
            } else {
                bw.write("!\n");
            }

        }


        bw.flush();
        bw.close();
    }

}
