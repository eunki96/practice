package aim_to_platinum.week12_graph.b2667;

/*
1. 문제 요약
- 지도를 입력받고, 연결된 집의 모임 = 단지 라고 할 때,
    각 단지별 집의 수를 오름차순으로 정렬하여 출력한다 (구분은 띄어쓰기)
- 지도의 한 변의 길이를 N 이라고 할 때, (5 ≤ N ≤ 25) 이다
    시간 제한 : 1초
    메모리 제한 : 128MB


2. 아이디어 (문제 접근법)
[아이디어-1]
- N 의 크기가 최대 25이므로 DFS, BFS 아무거나 사용해도 상관 없을 듯 하다
- board[0][0] 부터 board[N-1][N-1] 순회
    - 중간에 1 만나면 BFS 실행
    - BFS 실행 시 total++
    - 단지별 집의 수 리스트에 추가
- 리스트 정렬, 출력

3. 어려움 및 해결
-
*/

import java.util.*;
import java.io.*;

public class BOJ_2667_단지번호_붙이기 {
    static int[] mx = {1, 0, -1, 0};
    static int[] my = {0, 1, 0, -1};
    static ArrayList<Integer> answerList = new ArrayList<>();
    static int total = 0;
    static int N;
    static int[][] board;

    static boolean[][] isVisited;
    public static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        isVisited[x][y] = true;
        queue.offer(new int[] {x, y});
        int count = 1;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int tempX = temp[0];
            int tempY = temp[1];
            for(int i = 0; i < 4; i++){
                int nx = tempX + mx[i];
                int ny = tempY + my[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                    continue;
                }

                if(board[nx][ny] == 1 && !isVisited[nx][ny]){
                    count++;
                    isVisited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        answerList.add(count);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        isVisited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String[] houseData = br.readLine().split("");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(houseData[j]);
                isVisited[i][j] = false;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!isVisited[i][j] && board[i][j] == 1){
                    BFS(i, j);
                    total++;
                }
            }
        }

        sb.append(total).append("\n");
        Collections.sort(answerList);
        for(int i : answerList){
            sb.append(i).append("\n");
        }

        sb.setLength(sb.length() - 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
