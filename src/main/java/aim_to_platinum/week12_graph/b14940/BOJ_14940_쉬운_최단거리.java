package aim_to_platinum.week12_graph.b14940;
/*
1. 문제 요약
- 세로 크기 n, 가로 크기 m을 입력받고
    n X m 크기의 지도에 0, 1, 2를 입력받는다
    (2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)
    0은 갈 수 없는 땅
    1은 갈 수 있는 땅
    2는 목표지점이다
    n X m 지도 각 좌표에 목표지점까지의 거리를 출력하면 된다
    (움직일 수 있는 방향은 상하좌우)
    시간 제한 : 1초
    메모리 제한 : 128MB

2. 아이디어 (문제 접근법)
[아이디어-1]
- 정답 board 의 값으로 방문 여부를 파악할 수 있으니
    isVisited 는 사용하지 않아도 된다
    목표지점 기준 BFS 실행하고
    각 분기마다 증가하는 값을 입력하면 목표지점까지의 거리가 된다

3. 어려움 및 해결
-
*/

import java.util.*;
import java.io.*;

public class BOJ_14940_쉬운_최단거리 {
    static int n, m, I, J;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] board;
    static int[][] answer;

    public static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        answer[i][j] = 0;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int now = answer[temp[0]][temp[1]];

            for(int k = 0; k < 4; k++){
                int nx = temp[0] + dx[k];
                int ny = temp[1] + dy[k];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }

                if(answer[nx][ny] == -1 && board[nx][ny] == 1){
                    queue.offer(new int[] {nx, ny});
                    answer[nx][ny] = now + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        board = new int[n][m];
        answer = new int[n][m];

        for(int i = 0; i < n; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
                if(board[i][j] == 2){
                    I = i;
                    J = j;
                }
                answer[i][j] = -1;
            }
        }

        BFS(I, J);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(answer[i][j] == -1 && board[i][j] == 0){
                    sb.append(0).append(" ");
                }else {
                    sb.append(answer[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

