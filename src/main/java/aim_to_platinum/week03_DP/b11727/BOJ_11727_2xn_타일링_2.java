package aim_to_platinum.week03_DP.b11727;

/*
그림으로 풀었다

2Xn 타일 -> 2X(n+1) 로 변할 때
이는 곧
2Xn 타일 모든 경우에 2X1 타일 하나를 더한 경우 혹은
2X(n-1) 타일 모든 경우에 2X2 타일 혹은 1x2(2) 를 더한 경우이다

따라서
(n) = (n-1) + 2(n-2) 이다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727_2xn_타일링_2 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        arr[1] = 1;
        if(N>1) arr[2] = 3;

        for(int i=3; i<=N; i++){
            arr[i] = ( arr[i-1] + 2*arr[i-2] ) % 10007;
        }

        System.out.println(arr[N]);
    }
}