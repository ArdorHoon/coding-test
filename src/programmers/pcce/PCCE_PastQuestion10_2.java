package programmers.pcce;

import java.util.ArrayList;
import java.util.Comparator;

public class PCCE_PastQuestion10_2 {

    /*
        문제 : [PCCE 기출문제] 10번 / 데이터 분석
        언어 : Java
        난이도 : Level 1
     */
    public static void main(String[] args) {

        Solution solution = new Solution();

        solution.solution(new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}, "date", 20300501, 	"remain");


    }

    public  static class Solution {
        public   ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {

            ArrayList<int[]> temp = new ArrayList<>();

            switch (ext){
                case "code":
                    for (int[] item : data) {
                        if (item[0] <= val_ext) {
                            temp.add(item);
                        }
                    }
                    break;
                case "date":
                    for (int[] value : data) {
                        if (value[1] <= val_ext) {
                            temp.add(value);
                        }

                    }
                    break;
                case "maximum":
                    for (int[] ints : data) {
                        if (ints[2] <= val_ext) {
                            temp.add(ints);
                        }

                    }
                    break;
                case "remain":
                    for (int[] datum : data) {
                        if (datum[3] <= val_ext) {
                            temp.add(datum);
                        }

                    }
                    break;

            }

            return sorting(sort_by, temp);

        }
        
        public static ArrayList<int[]>  sorting(String sort_by, ArrayList<int[]> data){
            switch (sort_by){
                case "code":
                    data.sort(Comparator.comparingInt(o -> o[0]));
                    break;
                case "date":
                    data.sort(Comparator.comparingInt(o -> o[1]));
                    break;
                case "maximum":
                    data.sort(Comparator.comparingInt(o -> o[2]));
                    break;
                case "remain":
                    data.sort(Comparator.comparingInt(o -> o[3]));
                    break;
            }

            return data;
        }
    }
}
