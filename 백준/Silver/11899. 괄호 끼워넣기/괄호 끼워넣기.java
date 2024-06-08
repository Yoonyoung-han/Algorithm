import java.io.*;

/*
* 앞에서 확인 -> )
* 뒤에서 확인 -> (
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int n = S.length();

        int frontCnt = 0;
        int backCnt = 0;
        for (char cha : S.toCharArray()){
            // 뒤에서 조건부터 체크
            if (cha == '(') {
                backCnt++;
             } else if (cha == ')') {
                // 열린 괄호면 열린 괄호 만큼 빼줌
                if (backCnt>0){
                    backCnt--;
                }else {
                    // 앞에서 부터 체크하는 조건
                    frontCnt++;
                }
            }
        }

        bw.write(frontCnt+backCnt+"\n");

        bw.flush();
        bw.close();
    }

}
