package org.example.server_study.week06.b11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int[] countArr = new int[N];

        int answer = Integer.MIN_VALUE;

        countArr[0] = 1;

        for(int i=1; i<N; i++){
            countArr[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i] && countArr[j]>=countArr[i]){
                    countArr[i] = countArr[j]+1;
                }
            }
        }

        for(int x : countArr){
            answer = Math.max(answer, x);
        }

        System.out.print(answer);

    }
}
