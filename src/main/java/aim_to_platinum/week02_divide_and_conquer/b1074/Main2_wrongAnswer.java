package aim_to_platinum.week02_divide_and_conquer.b1074;

/*
배열 한 변의 길이는 2^N
한 변이 2^(N-1)인 사각형 4개로 나누어
    왼쪽 위 - 오른쪽 위 - 왼쪽 아래 - 오른쪽 아래 순서
한 변의 길이가 2가 되었을 때 static int number 를 대입하면 됨
이후 board[r][c]의 값을 출력하면 됨

-> 메모리 초과 발생
board 전체를 recursion() 해서 그런 것으로 생각됨
r, c의 위치를 계속 추척해, 해당하는 영역만 recursion 할 필요 있다

-> number++이 덜 실행되어 당연히 훨씬 작은 값 나옴

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2_wrongAnswer {

    static int N;
    static int r;
    static int c;

    static int[][] board;

    static int number = 0;
    static void recursion(int startRow, int startColumn, int size){
        if(size==2){
            board[startRow][startColumn] = number++;
            board[startRow][startColumn+1] = number++;
            board[startRow+1][startColumn] = number++;
            board[startRow+1][startColumn+1] = number++;
        }else{
            int newSize = size/2;
            if(startRow<=r && r<startRow+newSize && startColumn<=c && c<startColumn+newSize) {
                recursion(startRow, startColumn, newSize);
            }else if(startRow<=r && r<startRow+newSize && startColumn+newSize<=c && c<startColumn+size){
                recursion(startRow, startColumn+newSize, newSize);
            }else if(startRow+newSize<=r && r<startRow+size && startColumn<=c && c<startColumn+newSize){
                recursion(startRow+newSize, startColumn, newSize);
            }else if(startRow+newSize<=r && r<startRow+size && startColumn+newSize<=c && c<startColumn+size){
                recursion(startRow+newSize, startColumn+newSize, newSize);
            }

        }
    }

        static void showBoard(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        N = (int)Math.pow(2, n);
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        board = new int[N][N];

        recursion(0, 0, N);

        showBoard();

        System.out.println(board[r][c]);
    }
}
