import java.io.*;

/*
*
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int max = -1;
            String schoolName = "";
            for (int j = 0; j < N; j++) {
                String[] s = br.readLine().split(" ");
                int consumption = Integer.parseInt(s[1]);
                // 술 소비량이 많으면
                if (consumption> max){
                    // 최댓값 업데이트
                    max = consumption;
                    // 학교이름 대체
                    schoolName = s[0];
                }
            }
            bw.write(schoolName+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
