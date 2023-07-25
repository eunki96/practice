package aim_to_platinum.week08_review.b1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
1. 문제 요약
- 각 마을당 한 명의 학생들이 있다
    마을의 수 = 학생의 수 N(1 ≤ N ≤ 1,000) 을 입력받는다
- 단방향 도로의 개수 M(1 ≤ M ≤ 10,000) 을 입력받는다
- 파티장소 X(1 ≤ X ≤ N) 를 입력받는다
- 이후 M번 만큼 from, to, weight(1 ≤ weight ≤ 100) 를 입력받는다
    - 이 때 시작점과 끝 점이 같은 도로는 없다
    - from 에서 to 로 가는 도로의 수는 1개 이하이다
- 최종적으로 마을->X->마을 의 비용이 가장 많이 드는 학생의 소요시간을 출력하면 된다


2. 아이디어 (문제 접근법)
[아이디어-1]
- 단방향 도로이기 때문에 마을->X 와 X->마을의 최소 소요 시간이 다를 수 있다
- Floyd 알고리즘으로 모든 최단 경로를 파악한 뒤 총 시간을 구할 수 있지만
    Floyd 알고리즘의 시간복잡도는 N^3 이므로 (1 ≤ N ≤ 1,000) 인 상황에서
    사용했다가는 시간초과가 발생한다.
    - 따라서 Dijkstra 알고리즘을 사용해
        1. X->다른 모든 마을 까지의 최단 경로
        2. 다른 모든 마을->X 까지의 최단 경로
      를 알아내 더하면 각 학생의 최소 소요 시간을 구할 수 있다.
    1 ->

3. 어려움 및 해결
-
 */

class Town implements Comparable<Town>{
    int number;
    int weight;
    public Town(int number, int weight){
        this.number = number;
        this.weight = weight;
    }
    @Override
    public int compareTo(Town o){
        return this.weight - o.weight;
    }
}

public class BOJ_1238_파티 {

    static int student, load, party;
    static ArrayList<ArrayList<Town>> list;
    static ArrayList<ArrayList<Town>> reverseList;

    static int[] Dijkstra(){
        return null;
    }

    public static void main(String[] args) throws IOException {

    }
}
