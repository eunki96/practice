package aim_to_platinum.week01_backtracking.b16987;

/*
시간제한 2초로 충분하다고 생각
브루트 포스 방식으로 모든 경우의 수들 DFS 방식으로 건드린 다음
maxCount 를 출력하면 된다.
내구도와 무게 필드를 갖는 Egg 클래스를 만든다.

- 가장 왼쪽의 계란으로 시작한다
- 다른 계란들 중 하나를 친다 (DFS)
- 다음 계란을 집고 반복

    (치기 전)
    - 들고있는 계란이 제일 오른쪽 계란이라면 maxCount 갱신하고 종료한다
    - 들고 있는 계란 외의 모든 계란이 깨져있다면 maxCount 갱신하고 종료한다
    - 들고 있는 계란이 이미 깨져있다면 다음 계란을 집는다

    (칠 때) (for 0~N-1)
        - 들고 있는 계란과 치려던 계란이 같으면 continue
        - 치려던 계란이 깨져있다면 continue
    - 들고있는 계란과 친 계란의 내구도 변경을 적용한다
        - 들고 있던 계란이 깨지면 count++
        - 친 계란이 깨지면 count++
    - 다음 계란을 집는다 (DFS)

    - 다음 순서를 위해 복구한다
        - Egg의 내구도
        - count


- count 를 출력한다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Egg{
    int durability;
    int weight;
    public Egg(int durability, int weight){
        this.durability = durability;
        this.weight = weight;
    }
}

public class Main {
    static void solution(int index, int count){
        if(index == N || count == N-1){
            maxCount = Math.max(maxCount, count);
            return;
        }
        if(eggArr[index].durability <= 0){
            solution(index+1, count);
            return;
        }

        int exCount = count;
        for(int i=0; i<N; i++){
            if(index == i) continue;

            Egg nowEgg = eggArr[index];
            Egg newEgg = eggArr[i];

            if(newEgg.durability <= 0) continue;

            nowEgg.durability -= newEgg.weight;
            if(nowEgg.durability <= 0) count++;

            newEgg.durability -= nowEgg.weight;
            if(newEgg.durability <= 0) count++;

            solution(index+1, count);

            //다음 반복문을 위해 복구
            nowEgg.durability += newEgg.weight;
            newEgg.durability += nowEgg.weight;
            count = exCount;
        }
    }

    static int N;

    static int maxCount = Integer.MIN_VALUE;
    static Egg[] eggArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = null;

        N = Integer.parseInt(br.readLine());
        eggArr = new Egg[N];
        for(int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine());
            eggArr[i] = new Egg(Integer.parseInt(stk.nextToken()),
                                Integer.parseInt(stk.nextToken()));
        }

        solution(0,  0);

        System.out.println(maxCount);
    }
}
