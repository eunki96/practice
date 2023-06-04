package aim_to_platinum.week03_DP.b1106;

/*
C 이상의 고객을 늘려야 하고 N 개의 도시가 있을 때 이를 입력받음
이후는 비용 : 얻는 고객의 수 입력받음

- 비용당 얻을 수 있는 고객의 수 (얻는 고객의 수/비용) 가 가장 많은 도시를 고르고
- 그 도시에 C 만큼의/C를 넘지 않는 만큼의 투자르 한 후
- 도시들 중 가장 적은 비용으로 C 이상이 되는 도시에 투자하기
위와같은 방법으로 풀려고 한다

힌트 참고 -> 적어도 C명의 고객을 얻는 것이 목표이기에
    C명 얻는 비용 > C+n명 얻는 비용
    이런 상황도 발생 가능하다..

한 번에 얻을 수 있는 고객의 수는 100명 이하이므로 최대 C+100명의 고객을 얻을 수 있다
각 index 별 최소 비용을 기록할 배열 costForIdx[C+101]
최소 비용을 구할 것이므로 배열의 각 요소들을 MAX_VALUE 로 세팅한다

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106_호텔 {

    static int[] costForIdx; // index 명을 늘릴때의 cost
    static int maxPeople;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(stk.nextToken()); // C명 이상의 고객
        int N = Integer.parseInt(stk.nextToken()); // 도시의 개수 N
        maxPeople = C+100;

        costForIdx = new int[maxPeople+1]; // 한 번에 얻을 수 있는 고객의 수 <= 100
        // 각 Index 만큼의 고객을 얻기 위해 필요한 최소 비용을 MAX_VALUE 로 세팅
        Arrays.fill(costForIdx, Integer.MAX_VALUE);

        // 나중 정수배만큼 투자하는 부분을 위해 세팅해야 한다
        costForIdx[0] = 0;

        for(int i=0; i<N; i++){
            // 각 도시별로 비용별 얻을 수 있는 사람의 수를 입력받고
            stk = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(stk.nextToken());
            int customer = Integer.parseInt(stk.nextToken());

            // cost 로 얻을 수 있는 사람의 수 부터 최대 얻을 수 있는 사람의 수 까지 순회
            // 순회하며 현재 최소 비용과 (현재 - cost 로 얻을 수 있는 사람의 수)의 비용중 더 작은 값으로 업데이트 한다
                // 정수배만큼 추가로 투자하는 부분
            // 만약 업데이트 되어있지 않다면 값을 구할 수 없으므로 패스한다
            for(int j=customer; j<=maxPeople; j++){
                if(costForIdx[j-customer] == Integer.MAX_VALUE) continue;
                costForIdx[j] = Math.min(costForIdx[j], costForIdx[j-customer]+cost);
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=C; i<=maxPeople; i++){
            answer = Math.min(answer, costForIdx[i]);
        }
        System.out.println(answer);
    }
}
