class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        quadTree(arr,0,0,arr.length);
        return answer;
    }

    public void quadTree(int[][] arr,int x, int y, int size) {
        // 같은 숫자일 때 카운팅
        if (sameNumber(arr, x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }
        // 숫자가 다르면 다시 분할하여 검색
        else {
            int halfSize = size / 2;
            quadTree(arr,x, y, halfSize); //왼쪽 위
            quadTree(arr,x, y + halfSize, halfSize);//오른쪽 위
            quadTree(arr,x + halfSize, y, halfSize);//왼쪽 아래
            quadTree(arr,x + halfSize, y + halfSize, halfSize);//오른쪽 아래
        }
    }

    // 같은 숫자인지 판별
    public boolean sameNumber(int[][] arr,int x, int y, int size){
        for (int i = x; i < x+size; i++){
            for (int j = y; j< y+size; j++){
                // 같지 않을 때 바로 반복문을 나가야 쓸데없는 반복횟수를 줄인다
                if (arr[x][y] != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}