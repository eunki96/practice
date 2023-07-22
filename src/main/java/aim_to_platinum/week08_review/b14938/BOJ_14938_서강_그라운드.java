package aim_to_platinum.week08_review.b14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//틀림

class Area{
    int number;
    int items;

    Area(int number, int items){
        this.number = number;
        this.items = items;
    }
}

public class BOJ_14938_서강_그라운드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(stk.nextToken());
        int range = Integer.parseInt(stk.nextToken());
        int edge = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        Area[] area = new Area[node+1];
        for(int i=1; i<=node; i++){
            int items = Integer.parseInt(stk.nextToken());
            area[i] = new Area(i, items);
        }

        int[][] board = new int[node+1][node+1];
        for(int i=0; i<edge; i++){
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int value = Integer.parseInt(stk.nextToken());
            board[n1][n2] = value;
            board[n2][n1] = value;
        }

        for(int i=1; i<=node; i++){
            for(int j=1; j<=node; j++){
                for(int k=1; k<=node; k++){
                    if(board[i][j] > board[i][k] + board[k][j]){
                        board[i][j] = board[i][k] + board[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=node; i++){
            for(int j=1; j<=i; j++){
                if(board[i][j] <= range){
                    answer += board[i][j];
                }
            }
        }

        System.out.println(answer);
    }
}
