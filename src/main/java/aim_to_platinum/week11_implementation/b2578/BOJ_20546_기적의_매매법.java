package aim_to_platinum.week11_implementation.b2578;
/*
1. 문제 요약
- 준현과 성민 각각의 투자 전략을 구현하고 14일 누가 더 수익률이 높은지 구한다

- 준현의 전략
    - 매일매일 살 수 있는 최대한의 주식을 산다
    - 한 번 산 주식은 절대 팔지 않는다
- 성민의 전략
    - 3일 연속 주가 상승 시 전량 매도한다
    - 3일 연속 주가 하락 시 전량 매수한다


2. 아이디어 (문제 접근법)
[아이디어-1]
-


3. 어려움 및 해결
-
*/


import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20546_기적의_매매법 {

    public class Investor{
        String name;
        int money;
        int stock;

        Investor(String name, int money, int stock){
            this.name = name;
            this.money = money;
            this.stock = stock;
        }
    }

    static int DATE = 14;
    static int[] dateArr = new int[DATE];
    static int dayCount = 0;
    static int price;

    static void BNP(Investor joonHyeon){

    }
    static void TIMING(Investor sungMin){

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int budget = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < DATE; i++){
            dateArr[i] = Integer.parseInt(stk.nextToken());
        }

        while(DATE-- > 0){
            
        }


    }
}
