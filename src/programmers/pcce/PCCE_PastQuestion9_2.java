package programmers.pcce;


/*
    문제 : [PCCE 기출문제] 9번 / 이웃한 칸
    언어 : Java
    난이도 : Level 1
 */

public class PCCE_PastQuestion9_2 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println( solution.solution(new String[][]{
                {"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}
        }, 1 ,1));
    }

    public static class Solution {
        public int solution(String[][] board, int h, int w) {
            
            int answer = 0;
            //행의 갯수(h)
            int row = board.length;
            //렬의 갯수(w)
            int col = board[0].length;

            String currentColor = board[h][w];

            //아래
            if(h+1 < row && board[h+1][w].equals(currentColor)){
                answer++;
            }

            //위
            if(h-1 >= 0 && board[h-1][w].equals(currentColor)){
                answer++;
            }

            //왼쪽
            if(w-1 >= 0 && board[h][w-1].equals(currentColor)){
                answer++;
            }

            //오른쪽
            if(w+1 < col && board[h][w+1].equals(currentColor)){
                answer++;
            }

            return answer;
        }
    }
}
