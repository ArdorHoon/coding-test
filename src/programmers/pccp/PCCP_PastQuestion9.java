package programmers.pccp;

/*
    문제 : [PCCE 기출문제] 9번 / 지폐 접기
    언어 : Java
    난이도 : Level 1
 */
public class PCCP_PastQuestion9 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer= solution.solution(new int[]{50, 50},new int[]{100, 241});

        System.out.println(answer);
    }


    public static class Solution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;

            while (!check(wallet, bill)){

                if(bill[0] > bill[1]){
                    bill[0] = bill[0]/2;
                }else {
                    bill[1] = bill[1]/2;
                }

                answer+=1;
            }

            return answer;
        }

        public boolean check(int[] wallet, int[] bill){
            return (wallet[0] >= bill[0] && wallet[1] >= bill[1]) || (wallet[0] >= bill[1] && wallet[1] >= bill[0]);
        }
    }

}
