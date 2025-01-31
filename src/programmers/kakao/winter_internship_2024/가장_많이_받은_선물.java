package programmers.kakao.winter_internship_2024;

import java.util.Arrays;

public class 가장_많이_받은_선물 {


    /*
    1. 선물을 서로 주고 받았나?
    2. 선물을 서로 주고 받지 않거나 같다?
        1. 선물 지수가 더 큰 사람이 작은 사람에게 하나 더 받는다.
        2. 선물 지수도 같다면 서로 주고 받지 않음
     */
    public static void main(String[] args) {

        String[] friends = new String[]{"muzi", "ryan", "frodo", "neo"};
        String[] gifts = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        Solution solution = new Solution();

        System.out.println(solution.solution(friends, gifts));

    }

    public static class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;

            int[][] matrix = new int[friends.length][friends.length];
            int[] giftIndex = new int[friends.length];


            //받은 선물, 준 선물
            for(int i = 0; i <gifts.length ; i++){

                String[] temp = gifts[i].split(" ");

                matrix[searchIndex(temp[0], friends)][searchIndex(temp[1], friends)]++;

            }

            //선물 지수
            for(int j = 0 ; j < giftIndex.length ; j ++){

                int give = 0;
                int get = 0;

                for(int k = 0 ; k < giftIndex.length ;  k++){
                    if(j!=k){
                        give += matrix[j][k];
                        get += matrix[k][j];
                    }
                }

                giftIndex[j] =  give -get;

            }

            for(int k = 0 ; k < friends.length ; k++){
                int rGift = 0;

                for(int i = 0 ; i <friends.length ; i++){

                    if(k != i){
                        //선물을 서로 주고 받지 않거나 같다?
                        if(matrix[k][i] == matrix[i][k] || (matrix[k][i] == 0 && matrix[i][k] ==0)){
                            if(giftIndex[k] > giftIndex[i])
                                rGift++;

                        }else{
                            if(matrix[k][i] > matrix[i][k])
                                rGift++;

                        }


                    }
                }

                if(rGift > answer)
                    answer = rGift;
            }


            return answer;
        }


        public int searchIndex(String name, String[] friends){

            for(int i = 0 ; i < friends.length ; i++){
                if(name.equals(friends[i])){
                    return i;
                }
            }

            return -1;

        }
    }
}
