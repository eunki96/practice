package aim_to_platinum.week08_review.b1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
1. 문제 요약
-


2. 아이디어 (문제 접근법)
[아이디어-1]
-


3. 어려움 및 해결
-
 */
class Node implements Comparable<Node>{
    int number;
    int weight;
    Node(int number, int weight){
        this.number = number;
        this.weight = weight;
    }
    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}
public class BOJ_1753_최단경로 {
    static int node, edge, start;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int[] minDist;
    static boolean[] isVisited;

    static void Dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int nowNumber = now.number;

            if(isVisited[nowNumber]){
                continue;
            }
            isVisited[nowNumber] = true;

            for(Node n : list.get(nowNumber)){
                if(!isVisited[n.number] && minDist[n.number] > minDist[nowNumber] + n.weight){
                    minDist[n.number] = minDist[nowNumber] + n.weight;
                    pq.offer(new Node(n.number, minDist[n.number]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        node = Integer.parseInt(stk.nextToken());
        edge = Integer.parseInt(stk.nextToken());
        start = Integer.parseInt(br.readLine());

        minDist = new int[node + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        isVisited = new boolean[node + 1];

        for(int i=0; i<=node; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<edge; i++){
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());
            list.get(from).add(new Node(to, weight));
        }

        Dijkstra();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=node; i++){
            int temp = minDist[i];
            if(temp == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else if(temp == start){
                sb.append("0").append("\n");
            }else{
                sb.append(temp).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
