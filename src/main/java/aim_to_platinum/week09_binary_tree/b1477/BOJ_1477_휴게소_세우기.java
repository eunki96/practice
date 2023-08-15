package aim_to_platinum.week09_binary_tree.b1477;
/*
1. 문제 요약
- 첫째줄에서 현재 휴게소의 개수 N(0 ≤ N ≤ 50)
    더 지으려고 하는 휴게소의 개수 M(1 ≤ M ≤ 100)
    고속도로의 길이 L(100 ≤ L ≤ 1,000)을 입력받는다
- 이어서 N개의 휴게소의 위치를 입력받는다
    고속도로의 끝과 이미 휴게소가 있는 곳에 휴게소를 설치할 수 없고
    입력받는 휴게소의 위치는 모두 정수일 때
- 휴게소가 없는 구간의 최댓값의 최솟값을 출력한다


2. 아이디어 (문제 접근법)
[아이디어-1]
- 휴게소를 짓고자 하는 구간을 찾는 문제이다
    이 때 지어야 하는 휴게소가


3. 어려움 및 해결
-
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1477_휴게소_세우기 {

    static boolean solution(int mid, int M, ArrayList<Integer> list){
        int count = 0;

        for(int i = 1; i < list.size(); i++) {
            count += (list.get(i) - list.get(i - 1) - 1) / mid;
        }

    //        if(count >= M){
        if(count > M){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int L = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(L);
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(stk.nextToken()));
        }
        Collections.sort(list);

        int min = 0;
        int mid;
        int max = L;
        while(min < max){
            mid = (min + max) / 2;
            if(solution(mid, M, list)){
                min = mid + 1;
            }else{
                max = mid;
            }
        }

        sb.append(min);
        bw.write(sb + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
