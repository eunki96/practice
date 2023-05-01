package org.example.server_study.week04.b5430;

/*
골드 치고는 너무 쉬운 문제가 아닌가 싶었는데, 다음 문장이 눈에 들어왔다.
[전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.]
정답률이 굉장히 낮다고 생각했는데, 분명 시간초과가 뜬 것이 분명했다.
알파벳 R과 D에 해당하는 연산을 수행해주는 것 이상으로 더 생각을 해 봐야 했다.

- R을 할 때마다 뒤집는 것 -> 시간초과의 원인들 중 하나
- 따라서 R이 들어왔을 경우 뒤집는 대신 boolean 값 isReversed 의 설정을 바꾸어 주면 된다.
    - isReversed == false
        - 그냥 맨 앞의 값을 버리면 된다.
    - isReversed == true
        - 반대로 맨 뒤의 값을 버리면 된다.
    - 연산을 마치고, isReversed 가 true 일 때 reverse() 를 실행한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque;
    static boolean isReversed = false;
    static StringBuilder sb = new StringBuilder();

    static void AC(String input){
        for(char x : input.toCharArray()){
            if(x == 'R'){
                isReversed = !isReversed;
                continue;
            }else{
                if(deque.isEmpty()){
                    sb.append("error\n");
                    return;
                }
                else {
                    if(!isReversed) deque.pollFirst();
                    else deque.pollLast();
                }
            }
        }

        sb.append('[');
        if(!deque.isEmpty()){
            if(!isReversed){
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()){
                    sb.append(',').append(deque.pollFirst());
                }
            }else{
                sb.append(deque.pollLast());
                while(!deque.isEmpty()){
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());// 테스트케이스 개수

        for(int i=0; i<T; i++){
            sb.setLength(0);
            isReversed = false;
            String input = br.readLine(); //명령어
            int n = Integer.parseInt(br.readLine()); //배열 길이
            stk = new StringTokenizer(br.readLine(), "[],"); //배열 입력
            deque = new ArrayDeque<Integer>();

            for(int j=0; j<n; j++){
                deque.offer(Integer.parseInt(stk.nextToken()));
            }

            AC(input);

            System.out.print(sb);
        }
    }
}