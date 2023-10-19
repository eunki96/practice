package aim_to_platinum.week12_graph.b16918;
/*
1. 문제 요약
- 크기가 R X C 인 board 가 있다고 할 때
    각 좌표는 빈칸/폭탄 둘중 한 상태이다
    폭탄은 설치 후 3초 뒤에 터진다

    아래는 봄버맨의 행동을 정리한 것이다
- [0초] 가장 처음 폭탄을 설치한다 (문제에서 주어진다) - 폭탄 1초
- [1초] 아무것도 하지 않는다 - 폭탄 2초
- [2초] 폭탄이 설치되지 않은 모든 칸에 폭탄을 설치한다 - 폭탄 3초
- [3초] 처음 설치한 폭탄이 터진다
- [4초] 폭탄이 설치되지 않은 칸에 폭탄을 설치한다
- [5초] 두 번째 설치한 폭탄이 터진다
.......
반복

    정리하면, 0초와 1초 이후
    짝수 초 -> 폭탄이 없는 곳에 폭탄을 설치한다
    홀수 초 -> 3초 전의 폭탄이 터진다
    를 반복한다

    이 때, 폭탄이 터지면 상하좌우로 빈칸으로 만든다
    폭탄의 연쇄 폭발은 없으므로 원래 폭탄이 있었다면 빈칸으로 바뀐다 <- (중요!!!)

    시간 제한 : 2초
    메모리 제한 : 512MB

2. 아이디어 (문제 접근법)
[아이디어-1]
- 모듈화를 할 필요가 있다
    - setBoom 메서드 : 빈 칸에 폭탄을 설치
    - check 메서드 : 매 초마다 폭탄들의 남은 초를 최신화
        - boom 메서드 : 폭발 조건을 만족하면 주변을 빈칸으로 만드는 메서드
            이 때, 이번에 터질 폭탄까지 없애버리면 안되므로
            빈칸으로 만들 좌표 리스트를 만들어 뒀다가 마지막에 한번에 터뜨린다
            또한, 터지는 과정에서 폭탄이 설치된 좌표를 초기화 하면 폭탄의 초를 없애줘야 한다 (폭탄 제거)

    위 메서드를 다음과 같이 반복
    - 2초 : setBoom, check
    - 3초 : check
    - 4초 : setBoom, check
    - 5초 : check
    .....
    반복


3. 어려움 및 해결
-
*/
import java.util.*;
import java.io.*;

public class BOJ_16918_봄버맨_log {

    static int R, C, N, count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    //폭탄의 초를 기록
    static int[][] boomTime;
    //폭탄의 위치를 기록
    static String[][] boomBoard;

    //빈 칸에 전부 폭탄 설치
    public static void setBoom(){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(boomBoard[i][j].equals(".")){
                    boomBoard[i][j] = "O";
                    boomTime[i][j] = 1;
                }
            }
        }
    }
    //폭탄 초 업데이트
    public static void check(){
        //폭발 좌표 리스트
        List<int[]> boomList = new ArrayList<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                //폭발 조건 맞춰지면 폭발
                if(boomTime[i][j] == 4){
                    //해당 좌표 boomList 에 추가 (boom 에서 한 번에 폭발 예정)
                    boomList.add(new int[]{i, j});
                    for(int k = 0; k < 4; k++){
                        //해당 좌표 상하좌우
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        //boomBoard 벗어나지 않으면
                        if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
                            continue;
                        }
                        //boomList 에 추가 (boom 에서 한 번에 폭발 예정)
                        boomList.add(new int[] {nx, ny});
                    }
                //폭발 조건은 아닌데, 폭탄 심어져 있으면 1초 추가
                }else if(boomTime[i][j] > 0){
                    boomTime[i][j]++;
                }
            }
        }
        //한 번에 폭발
        boom(boomList);
    }
    public static void boom(List<int[]> boomList){
        for(int[] arr : boomList){
            boomBoard[arr[0]][arr[1]] = ".";
            boomTime[arr[0]][arr[1]] = 0;
        }
    }

    public static void showBoard(){
        System.out.println("==== boom ====");
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(boomBoard[i][j]);
            }
            System.out.println();
        }
    }
    public static void showTime(){
        System.out.println("==== time ====");
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(boomTime[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        boomBoard = new String[R][C];
        boomTime = new int[R][C];

        count = 0;
        for(int i = 0; i < R; i++){
            String[] arr = br.readLine().split("");
            for(int j = 0; j < C; j++){
                boomBoard[i][j] = arr[j];
                if(boomBoard[i][j].equals("O")){
                    boomTime[i][j] = 2;
                }else{
                    boomTime[i][j] = 0;
                }
            }
        }
        System.out.println("\n==== COUNT " + count + "====");
        showBoard();
        showTime();

        count = 1;
        check();
        System.out.println("\n==== COUNT " + count + "====");
        showBoard();
        showTime();

        while(count < N){
            count++;
            System.out.println("\n==== COUNT " + count + "====");
            if(count % 2 == 0){
                setBoom();
                check();
                showBoard();
                showTime();
            }else{
                check();
                showBoard();
                showTime();
            }
        }
    }
}
