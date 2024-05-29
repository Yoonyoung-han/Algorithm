import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 수학, 구현 문제다
 * 1년은 365일인데, 각 월별로 갖고 있는 일수가 다른 점을 활용한다.
 * 요일이 7로 나눠지니까 나누고 남은 나머지를 사용해서 요일을 선택한다.
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int date = sc.nextInt();
        //요일 판별용 ArrayList
        ArrayList<String> days = new ArrayList<String>(List.of("SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"));

        // 각 월에 해당하는 일수 더하는 반복문
        for (int i = 1; i < month; i++) {
            if(i == 2){
                date += 28;
            }else if (i==4||i==6||i==9||i==11){
                date += 30;
            }else date += 31;
        }
        System.out.println(days.get(date%7));
    }
}
