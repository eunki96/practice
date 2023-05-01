package org.example.server_study.week04.b11286;

/*
1. 연산의 개수 n을 입력받는다. 이후 n 만큼의 반복을 실행하는 for 반복문을 만든다.
2. 입력값에 따라 출력 후 값 삭제 or 값 list 에 추가 -> 를 실행한다.
2-1. 0을 입력 받았을 경우 : list 에서 절댓값이 가장 작은 값을 출력한다.
    2-1-1. 절댓값이 가장 작은 값이 여러 개일 경우 : 가장 작은 수를 출력한다.
    - 이를 구현하기 위해 PriorityQueue 를 활용하고, Comparator 를 손봐주면 된다.
    - 두 값의 절댓값을 기준으로, 더 작은 값을 앞에 배치한다.
    - 두 값의 절댓값이 같다면, 그냥 크기를 비교해서 더 작은 값을 앞에 매치하면 된다.
2-2. 그 외 : 배열에 값을 입력한다.

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else if (Math.abs(o1) < Math.abs(o2)) {
                    return -1;
                } else {
                    return o1 - o2;
                }
            }
        });

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(bf.readLine());
            if (temp == 0) {
                if (pq.isEmpty()) sb.append(0 + "\n");
                else sb.append(pq.poll() + "\n");
            } else {
                pq.offer(temp);
            }
        }
        System.out.println(sb);
    }
}
