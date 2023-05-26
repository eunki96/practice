package aim_to_platinum.week02_divide_and_conquer.b1074;

/*
배열 한 변의 길이는 2^N
한 변이 2^(N-1)인 사각형 4개로 나누어
    왼쪽 위 - 오른쪽 위 - 왼쪽 아래 - 오른쪽 아래 순서
한 변의 길이가 2가 되었을 때 static int number 를 대입하면 됨
이후 board[r][c]의 값을 출력하면 됨
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1_memoryOver {

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
            recursion(startRow, startColumn, newSize);
            recursion(startRow, startColumn+newSize, newSize);
            recursion(startRow+newSize, startColumn, newSize);
            recursion(startRow+newSize, startColumn+newSize, newSize);
        }
    }

//    static void showBoard(int N){
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int N = (int)Math.pow(2, n);
        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        board = new int[N][N];
//        showBoard(N);

        recursion(0, 0, N);
//        showBoard(N);

        System.out.println(board[r][c]);
    }
}
