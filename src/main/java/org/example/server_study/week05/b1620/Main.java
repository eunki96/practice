package org.example.server_study.week05.b1620;

/*
N개의 줄에 1~N 번의 포켓몬들이 입력된다.
문제 M개가 주어진다.
포켓몬 이름이 주어지면 번호를 말하고, 번호가 주어지면 포켓몬을 말한다.
N의 범위가 1~100,000 이기에
  - 배열 사용시 숫자에 대응되는 포켓몬을 찾는것은 빠를 수 있어도
  - 포켓몬이 위치한 인덱스를 찾는 것은 O(N)의 시간복잡도로 인해 비효율적이다.
이를 해결하기 위해 String 배열과 MashMap<String, Integer> 를 함께 사용한다.

1. HashMap<String, Integer> pMap 와 String[N+1] pArr 을 만든다.
2. N 줄 동안 입력 put(포켓몬이름, 번호), pArr[1~N] = 포켓몬이름
3. M 줄 동안 출력
    - String 포켓몬이름 입력받을 경우 -> get(포켓몬이름)
    - int 번호 입력받을 경우 -> pArr[번호] = 포켓몬이름
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
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        HashMap<String, Integer> pMap = new HashMap<>();
        String[] pArr = new String[N+1];

        for(int i=1; i<=N; i++){
            String pName = br.readLine();
            pMap.put(pName, i);
            pArr[i] = pName;
        }

        for(int i=0; i<M; i++){
            String input = br.readLine();
            boolean isNumber = true;
            for(char x : input.toCharArray()){
                if(!Character.isDigit(x)){
                    isNumber = false;
                    break;
                }
            }
            if(isNumber){
                sb.append(pArr[Integer.parseInt(input)] + "\n");
            }else{
                sb.append(pMap.get(input) + "\n");
            }
        }

        System.out.println(sb);
    }
}
