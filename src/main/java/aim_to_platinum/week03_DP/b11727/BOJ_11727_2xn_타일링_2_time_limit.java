package aim_to_platinum.week03_DP.b11727;

/*
2Xn 직사각형을 1X2, 2X1, 2X2 타일로 채우는 방법의 수
- 1X2나, 2X2나 둘 다 가로 2칸을 차지한다
[1] - 가로의 길이 n을 길이 1과 2로 채울 수 있는 모든 경우를 구한다
[2] - 길이 2로 채우는 경우의 수는 1X2타일 두개로 채우는 경우와 2X2타일 하나로 채우는 경우 두 가지만 있다
    - 길이 2로 채운 부분의 수 T 에 대하여 1X2와 2X2 두 가지 경우를 적용시키면 된다. (2^T)

[1]
[2] Math.pow(2, 가로2 타일 개수)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727_2xn_타일링_2_time_limit {
    static int N;
    static int answer;

    static void DFS(int now, int count){
        if(now>N) {
            return;
        }
        if(now==N){
            answer += Math.pow(2, count);
        }
        DFS(now+1, count);
        DFS(now+2, count+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(0, 0);

        System.out.println(answer%10007);
    }
}
