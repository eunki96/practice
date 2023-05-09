package org.example.server_study.week06.b1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp[0] = arr[0];
        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        }
        int answer = Integer.MIN_VALUE;
        for(int x : dp){
            answer = Math.max(answer, x);
        }
        System.out.println(answer);
    }
}
