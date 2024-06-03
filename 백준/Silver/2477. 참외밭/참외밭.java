import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 --------------------------------------------------
 * 수학 문제
 * 가장 큰 넓이 직사각형 - 가장 작은 넓이 직사각형
 * 넓이 계산 * 참외 수
 * 동쪽(오른쪽) 1, 서쪽(왼쪽) 2, 남쪽 3, 북쪽 4
 --------------------------------------------------
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // 참외갯수
        
        // 방향, 길이 정보 저장
        int[] dir = new int[6];
        int[] len = new int[6];
        int maxWidth = 0, maxHeight=0; // 큰 직사각형
        int maxWidthIndex = 0, maxHeightIndex = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
            if (dir[i] < 3){ // 가로 길이 계산
                if (len[i] > maxWidth) {
                    maxWidth = len[i];
                    maxWidthIndex = i;
                }
            } else { // 세로 길이 계산
                if (len[i] > maxHeight) {
                    maxHeight = len[i];
                    maxHeightIndex = i;
                }
            }
        }

        // 작은 직사각형 계산
        // 큰 직사각형의 변의 인덱스에서 +3 떨어진 위치의 변을 사용
        int minWidth = len[(maxWidthIndex + 3) % 6];
        int minHeight = len[(maxHeightIndex + 3) % 6];

        // 큰 직사각형에서 작은 직사각형을 뺀 넓이를 계산
        int totalArea = (maxWidth * maxHeight) - (minWidth * minHeight);

        // 총 참외의 개수 계산
        int totalMelons = totalArea * K;

        System.out.println(totalMelons);

        br.close();
    }

}