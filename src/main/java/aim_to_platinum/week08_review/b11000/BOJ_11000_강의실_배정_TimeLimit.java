package aim_to_platinum.week08_review.b11000;
/*
1. 문제 요약
- 먼저 수업의 수 N을 입력받고
    N 만큼 수업의 시작과 종료 시간을 입력받는다 (0 ≤ S < T ≤ 109)
    최소 몇 개의 강의실만으로 강의를 소화할 수 있는지 알아내면 된다

2. 아이디어 (문제 접근법)
[아이디어-1]
- 먼저 시작시간 S와 종료시간 T를 갖는 수업 Class 클래스를 생성한다
- 이후 순서대로 강의를 받는다
- 진행중인 강의 리스트를 순회한다
    + 순회할 때마다 리스트의 크기를 체크해 최대값 classroom 을 알아낸다
    1. 다음 순서 강의 시작시간이
    진행중인 어떤 강의의 죵료시간보다 빠르다면
        - 그냥 리스트에 추가한다
    2. 다음 순서 강의 시작시간이
    진행중인 어떤 강의의 종료시간보다 같거나 뒤라면
        - 진행중인 강의를 리스트에서 제거하고 리스트에 새 강의를 넣는다

    - 이후 수업을 리스트에 담아 정렬한다
    이 때 정렬 기준은 다음과 같다
    1. 시작 시간
    2. 종료 시간

- 최종적으로 classroom 을 출력하면 된다


3. 어려움 및 해결
- [아이디어-1] 시간초과 발생
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class BOJ_11000_강의실_배정_TimeLimit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int classroom = Integer.MIN_VALUE;

        int N = Integer.parseInt(br.readLine());
        List<Class> list = new LinkedList<>();
        while(N-- > 0){
            stk = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(stk.nextToken());
            int endTime = Integer.parseInt(stk.nextToken());
            Class newClass = new Class(startTime, endTime);

            for(Class c : list){
                if(c.endTime <= newClass.startTime || newClass.endTime <= c.startTime) {
                    list.remove(c);
                    break;
                }
            }

            list.add(newClass);
            classroom = Math.max(classroom, list.size());
            Collections.sort(list);

//            for(Class cl : list){
//                System.out.println(cl.startTime + " ~ " + cl.endTime);
//            }
//            System.out.println();
        }



        System.out.println(classroom);
    }
}
