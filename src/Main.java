import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;



/*
어떤 수를 소수의 곱으로만 나타내는 것을 소인수분해라 하고, 이 소수들을 그 수의 소인수라고 합니다.
예를 들면 13195의 소인수는 5, 7, 13, 29 입니다.

600851475143의 소인수 중에서 가장 큰 수를 구하세요.
 */
public class Main {
    public static void main(String[] args) {
        int answer = 0;
        int number = 2;

        while (true){

            if(isPrimeNumber(number)) {
                answer++;
            }

            if(answer == 10001){
                System.out.println(number);
                break;
            }

            number++;

        }


    }

    public static boolean isPrimeNumber(int num){

        for(int i = 2 ;  i*i <= num ; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}

//    아래 input output
//    //Input
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    //Output
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//    int n = Integer.parseInt(br.readLine());
//
//    int[] arr = new int[n];
//
//    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < n; i++) {
//        arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        br.close();
//
//        //Solution
//
//        //Result
//        bw.append(Integer.toString(10)).flush();