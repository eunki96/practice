package org.example.server_study.week05.b10816;

/*
1. 갖고있는 카드의 개수 N 을 입력받는다.
2. N개 만큼 숫자를 입력받는다.
3. 정수 M을 입력받는다.
4. 숫자 M개를 입력받는다.
N 개의 배열을 돌면서 내부적으로 M 번의 탐색을 하는 것은 O(N^2)라는 엄청난 시간복잡도가 나오기에
HashMap<Integer, Integer> 를 사용하여 쉽게 풀 수 있다.
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int key = Integer.parseInt(stk.nextToken());
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            sb.append(map.getOrDefault(Integer.parseInt(stk.nextToken()), 0) + " ");
        }

        System.out.println(sb);
    }
}