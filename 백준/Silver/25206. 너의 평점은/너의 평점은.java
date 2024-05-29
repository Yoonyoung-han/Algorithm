import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

/** 
 --------------------------------------------------
 * 수학, 구현, 문자열 문제다
 * 학점*과목평점 합 / 학점 총합 구하기
 * 과목 평점, 평점 이름을 key, value로 놓고 매치
 * double형으로 계산
 --------------------------------------------------
 */

public class Main {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<String, Double> hashMap = Map.of(
                "A+", 4.5,
                "A0", 4.0,
                "B+",	3.5,
                "B0",	3.0,
                "C+",	2.5,
                "C0",	2.0,
                "D+",	1.5,
                "D0",	1.0,
               "F",	0.0
        );
        double sumScore = 0.0;
        double sumNum = 0.0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String scoreName = st.nextToken();

            if (!(scoreName.equals("P"))){
                sumScore += (score * hashMap.get(scoreName));
                sumNum += score;
            }

        }
        // 소수점 아래 6자리까지 출력
        System.out.printf("%.6f", sumScore/sumNum);
        br.close();
    }
}
