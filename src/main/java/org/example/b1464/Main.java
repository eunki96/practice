package org.example.b1464;

/*
문자열을 입력받고 앞부터 .reverse() 가 가능하다.
Brute Force 방식도 있지만 Greedy 방식 활용이 더 낫다.
1. 문자열 input 을 입력받고 앞부터 천천히 뒤집는다.
2. 뒤집을 때마다 check 메서드를 실행해 새로 생성한 문자열을 기존 제일 사전순 앞이던 문자열 answer 와 비교한다.
3. 비교해서 더 앞에 있으면 answer 를 업데이트하고, 더 뒤에 있으면 파기한다.
이게 Brute Force 방식이다.

그럼 Greedy 방식은?
1. input 의 문자를 앞에서부터 StringBuilder sb 에 추가해준다.
2-1. 문자가 추가될 때, 직전 들어온 문자열과 비교해서 더 작으면 뒤에 붙인다.
2-2. 문자가 추가될 때, 직전 들어온 문자열과 비교해서 더 크면 앞에 붙인다.
3. 즉, 제일 사전상 뒤에 있는 문자열을 만들고 마지막에 뒤집으면 끝난다.

- 앞에서부터 n 번째의 문자까지 뒤집게 되므로 앞쪽 인덱스일수록 reverse()의 영향을 많이 받는다.
- 즉, 사전상 앞서는 문자들이 오면 뒤로 보내놓고 마지막에 reverse()를 하면 된다.

문자가 들어올 때마다 앞 뒤로 보낼지 정한 결과는 뒤집거나 뒤집지 않는 과정 반복한 결과로 만들 수 있다.
- 두 번째 입력 문자를 앞으로 보냄 == 인덱스 1까지 reverse() 함, 반대의 경우 안함
- 세 번째 입력 문자를 앞으로 보냄 == 이전 reverse()를 반대로 하고 인덱스 2까지 reverse() 함, 반대의 경우 안함
- 네 번째 입력 문자를 뒤로 보냄 == 이전 reverse()를 그대로 두고 그 이전의 reverse()는 반대로 함, 인덱스 3까지 reverse() 함, 반대의 경우 안함
....
이런 식으로 같은 결과를 만들 수 있다.

정리
- 문자열이 추가될 때마다 현재의 마지막 문자보다 사전적으로 앞에 있다면 뒤로 보내고, 반대의 경우 앞으로 보낸다.
- 마지막에 reverse() 한다.
*/

// https://www.acmicpc.net/problem/1464

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder answer = new StringBuilder();
    static String input;
    static char now = Character.MAX_VALUE;

    static void check(){
        if(now > answer.charAt(answer.length()-1)) answer.insert(0, now);
        else answer.append(now);
//        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = bf.readLine();

        answer.append(input.charAt(0));
        for(int i=1; i<input.length(); i++){
            now = input.charAt(i);
            check();
        }

        System.out.println(answer.reverse().toString());
    }
}
