import java.io.*;
import java.util.*;

/*
* 문자열 조합, 정렬
* 입학년도%100 오름차순
* 해결한 문제 내림차순의 알파벳 첫글자
* */
public class Main {

    static class TeamMember {
        int solvedProblems;
        int year;
        char surname;

        TeamMember(int solvedProblems, int year, char surname) {
            this.solvedProblems = solvedProblems;
            this.year = year;
            this.surname = surname;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<TeamMember> members = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] var = br.readLine().split(" ");

            int P = Integer.parseInt(var[0]);
            int Y = Integer.parseInt(var[1])%100;
            char S = var[2].charAt(0);
            members.add(new TeamMember(P,Y,S));
        }

        // 첫 번째 팀명 생성: 입학 연도를 100으로 나눈 나머지로 오름차순 정렬
        StringBuilder teamName1 = new StringBuilder();
        members.stream()
                .sorted(Comparator.comparingInt(member -> member.year % 100))
                .forEach(member -> teamName1.append(member.year % 100));

        // 두 번째 팀명 생성: 해결한 문제의 수로 내림차순 정렬
        StringBuilder teamName2 = new StringBuilder();
        members.stream()
                .sorted((a, b) -> b.solvedProblems - a.solvedProblems)
                .forEach(member -> teamName2.append(member.surname));

        bw.write(teamName1+"\n");
        bw.write(teamName2+"\n");
        
        bw.flush();
        bw.close();
        br.close();
    }

}
