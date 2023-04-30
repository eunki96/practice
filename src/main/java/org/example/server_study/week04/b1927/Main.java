package org.example.server_study.week04.b1927;

/*
Java 의 PriorityQueue 는 기본적으로 최소 힙을 사용한다.
PriorityQueue 의 메서드들을 사용할 줄 알면 쉽게 풀 수 있는 문제이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(bf.readLine());
//        System.out.println(N);

        for(int i=0; i<n; i++){
            int input = Integer.parseInt(bf.readLine());
            if(input == 0){
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
            else{
                pq.offer(input);
            }
        }
    }
}
