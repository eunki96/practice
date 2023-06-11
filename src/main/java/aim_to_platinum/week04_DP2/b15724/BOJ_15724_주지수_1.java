package aim_to_platinum.week04_DP2.b15724;

/*
1. 문제 요약
- 제한시간 2초
- N x M 사이즈의 단위구역 내에 각 값을 입력받고
    - 이어서 시작행, 시작열, 끝행, 끝열을 입력받는다
해당 범위 내의 사람들의 수의 합을 구하는 문제이다

2. 아이디어 (문제 접근법)
[아이디어-1]
- int answer 를 만들어 범위 내의 합을 저장한다
- for 시작행-1 ~ 끝행-1
    for 시작열-1 ~ 끝열-1
        answer += 해당 위치 값
[아이디어-2]
- 시간을 줄이는 방법
    1.

3. 어려움 및 해결
[아이디어-1] -> 시간초과 발생
            -> 영토의 크기는 (1 ≤ N, M ≤ 1,024) 으로 잘 체감이 안되었는데
            -> 다시 확인하니 직사각형 범위의 개수 K(1 ≤ K ≤ 100,000) 였다
            -> 시간을 줄일 수 있는 방법을 고안해봄 ([아이디어-2]로)
-

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15724_주지수_1 {
    static int[][] board;

    static StringBuffer sb = new StringBuffer();

    static int N;
    static int M;

    public static int dp(int startRow, int startColumn, int endRow, int endColumn){
        int answer=0;
        for(int i=startRow-1; i<endRow; i++){
            for(int j=startColumn-1; j<endColumn; j++){
                answer+=board[i][j];
            }
        }
        return answer;
    }

    public static void show(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        board = new int[N][M];

        for(int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            sb.append(dp(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())) + "\n");
        }
        System.out.println(sb);
    }
}
