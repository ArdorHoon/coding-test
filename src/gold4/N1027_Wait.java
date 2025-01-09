package gold4;

import java.io.*;
import java.util.*;

// url : https://www.acmicpc.net/problem/1027
/*
   Algorithm
   * 수학
   * 브루트포스 알고리즘
   * 기하학
 */
public class N1027_Wait {
    public static void main(String[] args) throws IOException {

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();


        //Solution


        //Result
        bw.append(Integer.toString(10)).flush();
    }
}
