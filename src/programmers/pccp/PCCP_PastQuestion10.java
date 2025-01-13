package programmers.pccp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PCCP_PastQuestion10 {

    public static void main(String[] args) {

        int[] mats = new int[]{5, 3, 2};
        String[][] park = new String[][]{
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
        };

        Solution solution = new Solution();
        System.out.println(solution.solution(mats, park));
    }


    public static class Solution {
        public int solution(int[] mats, String[][] park) {
            int answer = -1;
            List<Integer> reverseOrderMats = Arrays.stream(mats).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            for (Integer reverseOrderMat : reverseOrderMats) {
                if (isPossibleMatInPark(reverseOrderMat, park)) {
                    answer = reverseOrderMat;
                    break;
                }
            }

            return answer;
        }
    }


    public static boolean isPossibleMatInPark(int num, String[][] park) {

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {

                boolean check = true;

                if (park[i][j].equals("-1") && i + num <= park.length && j + num <= park[i].length) {
                    for (int m = i; m < i + num; m++) {
                        for (int n = j; n < j + num; n++) {
                            if (!park[m][n].equals("-1")) {
                                check = false;
                                break;
                            }
                        }
                    }
                    if (check) return true;
                }
            }
        }

        return false;
    }
}
