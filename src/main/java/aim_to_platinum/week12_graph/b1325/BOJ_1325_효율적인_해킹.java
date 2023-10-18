package aim_to_platinum.week12_graph.b1325;

/*
1. 문제 요약
- 컴퓨터를 해킹하는 과정에서
    A 컴퓨터가 B 컴퓨터를 신뢰한다면
    B 컴퓨터를 해킹할 경우 A 컴퓨터를 해킹할 수 있다
    컴퓨터 간 신뢰하는 관계가 주어졌을 때,
    한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호 목록을 오름차순으로 출력하면 된다

    컴퓨터의 수 N -> 1 ~ 10,000
    신뢰 관계의 수 M -> 1 ~ 100,000
    시간 제한 : 5초
    메모리 제한 : 256MB

2. 아이디어 (문제 접근법)
[아이디어-1]
- 탐색 방법 : DFS
- 모델링 방식 : 인접 리스트
위 방식을 참고하여 해킹할 수 있는 컴퓨터의 최대 수가 제일 많은 번호를 찾으면 된다
    - 컴퓨터 해킹 시 해킹 가능한 컴퓨터 수를 구한다
    - 현재 최대 해킹 수와 비교한다
        - 적다면 -> 넘어간다
        - 같다면 -> 번호 리스트에 추가한다
        - 많다면 -> 기존 리스트를 초기화하고 번호를 추가한다
=> 시간초과 발생

3. 어려움 및 해결
- comA 가 comB 를 신뢰한다 -> list.get(comB).add(comA) 를
- comA 가 comB 를 신뢰한다 -> list.get(comA).add(comB) 로 수정
즉, list.get(i) 를 i를 해킹할 수 있는 컴퓨터 리스트로 바꿨다
이를 위해 arr[N + 1] 를 만들었다
=> 그래도 시간초과

인접 리스트를 수정하니 시간초과가 해결되었다
ArrayList<LinkedList<Integer>> list = new ArrayList<>(); (시간초과)
=> static LinkedList<Integer>[] arr; (시간초과)
=> static ArrayList<Integer>[] arr; (해결)

이게..실버 1?
*/

import java.util.*;
import java.io.*;

public class BOJ_1325_효율적인_해킹 {

    static ArrayList<Integer>[] arr;
    static boolean[] isVisited;
    static int[] countArr;

    public static void BFS(int now){
        Queue<Integer> queue = new LinkedList<>();
        isVisited[now] = true;
        queue.offer(now);

        while(!queue.isEmpty()){
            for(Integer tempCom : arr[(queue.poll())]){
                if(!isVisited[tempCom]){
                    countArr[tempCom]++; //tempCom 이 해킹할 수 있는 숫자가 증가
                    isVisited[tempCom] = true;
                    queue.offer(tempCom);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        isVisited = new boolean[N + 1];
        countArr = new int[N + 1];
        arr = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        int M = Integer.parseInt(stk.nextToken());
        while(M-- > 0){
            stk = new StringTokenizer(br.readLine());
            int comA = Integer.parseInt(stk.nextToken());
            int comB = Integer.parseInt(stk.nextToken());
            //comA 는 comB 를 신뢰한다

            //comB 를 해킹하면 comA 를 해킹 할 수 있다 (시간초과)
            //list.get(comB).add(comA); -> X(시간초과)

            //comA 는 comB 에게 해킹당할 수 있다
            arr[comA].add(comB);
        }

        for(int i = 1; i <= N; i++){
            isVisited = new boolean[N + 1];
            BFS(i);
        }

        int maxCount = 0;
        for(int count : countArr){
            maxCount = Math.max(count, maxCount);
        }

        for(int i = 1; i <= N; i++){
            if(countArr[i] == maxCount){
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

        bw.close();
        br.close();

    }
}
