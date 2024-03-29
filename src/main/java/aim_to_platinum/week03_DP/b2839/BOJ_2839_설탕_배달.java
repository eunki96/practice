package aim_to_platinum.week03_DP.BOJ_2839_설탕_배달;
/*
1. 문제 요약
- 사용 가능한 봉지는 5kg, 3kg의 두 종류이다
- N kg 을 가능한 적은 수의 봉지에 나누어 담아야 한다
- 만약 나누어 떨어지지 않는다면 -1을 출력한다


2. 아이디어
- 처음 아이디어
    - N kg 을 가능한 적은 개수의 봉지에 담기 위해서는
    - N/5 개수의 5kg 봉지와
    - N%5 / 3 개수의 3kg 봉지에 담으면 된다
    - 만약 N 이 5보다 작다면 -1을 출력한다
    - 만약 N%5 가 3으로 나누어 떨어지지 않는다면 -1을 출력한다

-> 하지만 6과 11의 경우 위의 방법이 먹히지 많는다
6의 경우 3kg 봉지 두 개를 쓰면 되고 11의 경우 5kg 봉지 하나와 3kg 봉지 두 개를 쓴다
단순히 5로 나눠서 해결되는 문제가 아니므로 우선 N에 따른 최소 봉지의 수를 정리하면 다음과 같다

N    1  2  3  4 | 5  6  7  8  9 | 10 11 12 13 14 | 15 16 17 18 19 ...
N/5  0  0  0  0 | 1  1  1  1  1 |  2  2  2  2  2 |  3  3  3  3  3
5kg  0  0  0  0 | 1  0  0  1  0 |  2  1  0  2  1 |  3  2  1  3  2 ...
3kg  0  0  1  0 | 0  2  0  1  3 |  0  2  4  1  3 |  0  2  4  1  3 ...
봉지 -1 -1  1 -1 | 1  2 -1  2  3 |  2  3  4  3  4 |  3  4  5  4  5 ...

3 <= N <= 5000 이므로 3 아래는 고려하지 말자
그러면 다음과 같은 규칙이 나온다

N/5 -> N/5
N/5+1 -> N/5 + 1
N/5+2 -> N/5 + 2
N/5+3 -> N/5 + 1
N/5+4 -> N/5 + 2

예외 : 4, 7 -> -1

즉 이를 분류하면 다음과 같다
- 5의 배수인 경우
- 5의 배수+1 or 5의 배수+3
- 5의 배수+2 or 5의 배수+4
- 4, 7인 경우

각각에 해당하는 값을 출력해주면 된다
- 4, 7인 경우를 먼저 조건문으로 걸면 된다


3. 어려움 및 해결방식
- 처음에 모든 경우의 수를 구해야 하나 고민했지만
먼저 풀어보았던 BOJ_11727_2xn_타일링_2 문제에서의 경험을 통해 시간복잡도 문제가 발생함을 알 수 있었다
규칙을 찾고자 값을 나열하다보니 방법을 발견해버린 경우여서 근본적인 해결 방법은 아닌 것 같다

- 각 N을 5씩 나누어서 고려하면 당연하게 나오는 규칙이었다
5의 배수로 떨어지는 경우 : N/5 만큼의 봉지가 필요
N%5 = 3 인 경우 : N/5+1 만큼의 봉지가 필요 (3kg 봉지 하나만 추가하면 되기 때문)
N%5 = 1 인 경우 : 6, 11 ... 인데
                N=6이면 3kg 짜리 2개를 필요로 하고, 이후로 5씩 증가
N%5 = 4 인 경우 : 4, 9, 13 ... 인데 4는 제외하고
                N=9이면 3kg 짜리 3개를 필요로 하고, 이후로 5씩 증가
N%5 = 2 인 경우 : 7, 12, 17 ... 인데 7은 제외하고
                N=12이면 3kg 짜리 4개를 필요로 하고, 이후로 5씩 증가
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕_배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N==4 || N==7){
            System.out.println(-1);
        }else if(N%5 == 0){
            System.out.println(N/5);
        }else if(N%5 == 1 || N%5 == 3){
            System.out.println(N/5 + 1);
        }else if(N%5 == 2 || N%5 == 4){
            System.out.println(N/5 + 2);
        }
    }
}
