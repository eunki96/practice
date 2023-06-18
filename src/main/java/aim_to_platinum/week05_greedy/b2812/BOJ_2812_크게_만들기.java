package aim_to_platinum.week05_greedy.b2812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 요약
- N과 K (1 ≤ K < N ≤ 500,000) 를 입력받는다
- N 자리 숫자 input 을 입력받으면 그 중 K 만큼의 숫자를 지운다
    - 이 때 얻을 수 있는 가장 큰 수를 구하면 되는 문제이다

2. 아이디어 (문제 접근법)
[아이디어-1]
- input 을 String 으로 입력받은 후에 char[] sorted =  Arrays.sort 로 정렬한다
    이를 통해 입력받은 숫자들이 오름차순으로 나열된다
    이후 앞에서부터 (작은 숫자들부터) K 번째까지 문자들을 순회하며 해당 문자들을 삭제한다
    같은 문자의 경우 input 에서 더 앞에 있는 문자를 지운다

[아이디어-2]
- input 을 애초에 크기 N-K의 배열 arr 에 입력받아보자
- int count = K 로 할당하고
    int pointer = 0 으로 할당하여
    count = 0 이 될 때까지 앞자리수를 최대한 큰 숫자로 세팅할 수 있도록 다음과 같이 반복한다

    1. 현재 포인터가 가리키는 수가 없으면 (0이면) 입력받은 수를 넣는다
    2. 현재 포인터가 가리키는 수와 입력받은 수를 비교하여
        2-1. 포인터가 가리키는 수가 더 크고, count>0 이면 다음 수를 입력받는다
        2-2. count<=0 이면 입력받은 수를 다음 자리에 넣는다
        2-3. 입력받은 수가 더 크고, count>0 이면 그 숫자로 교체한다


3. 어려움 및 해결
[아이디어-1] -> 예제입력 3번에서 틀린 값이 출력될 것이다
            10 4 /n 4177252841 를 입력 받았을 때
            775841이 나와야 하지만 , 477584가 나온다
            그렇다면 무조건 앞자리 수를 최대로 맞추는 것에 초점을 둬보자
 */
public class BOJ_2812_크게_만들기 {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        String temp = br.readLine();
        char[] input = temp.toCharArray();

        
    }
}
