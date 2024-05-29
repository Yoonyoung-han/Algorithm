import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 --------------------------------------------------
 * 구현, 정렬 문제다
 * 조건에 따른 정렬
 * 금>은>동 순으로 우선순위 높음
 * 국가별로 클래스 만들어서 우선순위 비교 comparator 사용, 정렬
 * 메달 수 동일한 경우 공동 등수 부여
 --------------------------------------------------
 */
class Nation {
    int name; // 나라이름
    int gMedal; // 금
    int sMedal;  // 은
    int dMedal; // 동
    public Nation(int name,int gMedal, int sMedal, int dMedal) {
        this.name = name;
        this.gMedal = gMedal;
        this.sMedal = sMedal;
        this.dMedal = dMedal;
    }
}

class NationComparator implements Comparator<Nation>{
    @Override
    public int compare(Nation n1, Nation n2){
        // 금 개수가 같으면
        if(n1.gMedal == n2.gMedal){
            // 은 개수가 같으면
            if (n1.sMedal == n2.sMedal){
                // 동이 많은거
                return n2.dMedal - n1.dMedal;
            }
            return n2.sMedal - n1.sMedal;
        } else {
            // 금 개수가 많은거
            return n2.gMedal - n1.gMedal;
        }
    }
}

public class Main {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Nation> nations = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stTmp = new StringTokenizer(br.readLine());
            int name = Integer.parseInt(stTmp.nextToken());
            int gMedal = Integer.parseInt(stTmp.nextToken());
            int sMedal = Integer.parseInt(stTmp.nextToken());
            int dMedal = Integer.parseInt(stTmp.nextToken());
            nations.add(new Nation(name,gMedal,sMedal,dMedal));
        }

        nations.sort(new NationComparator());

        int[] ranks = new int[N + 1];
        int rank = 1;

        for (int i = 0; i < N; i++) {
            if (i > 0 && compareNations(nations.get(i), nations.get(i - 1)) != 0) {
                rank = i + 1;
            }
            ranks[nations.get(i).name] = rank;
        }

        System.out.println(ranks[K]);

    }

    private static int compareNations(Nation n1, Nation n2) {
        if (n1.gMedal != n2.gMedal) {
            return n1.gMedal - n2.gMedal;
        } else if (n1.sMedal != n2.sMedal) {
            return n1.sMedal - n2.sMedal;
        } else {
            return n1.dMedal - n2.dMedal;
        }
    }
}
