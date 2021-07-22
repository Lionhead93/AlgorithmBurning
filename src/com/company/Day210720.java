package com.company;

import java.util.*;

public class Day210720 {

    /**
     * 문제 설명
     * n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다.
     * 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
     * <p>
     * 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때,
     * 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
     * <p>
     * 제한사항
     * 노드의 개수 n은 2 이상 20,000 이하입니다.
     * 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
     * vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
     * 입출력 예
     * n	vertex	return
     * 6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
     * <p>
     * 입출력 예 설명
     * 예제의 그래프를 표현하면 아래 그림과 같고, 1번 노드에서 가장 멀리 떨어진 노드는 4,5,6번 노드입니다.
     *
     * @param n
     * @param edge
     * @return
     */
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];
        int answer;

        for (int i = 0; i <= n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {     // 양방향 추가해주기
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        answer = bfs();
        return answer;
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int cnt = 0;
        while (true) {
            Queue<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int adj : graph.get(cur)) {
                    if (!visited[adj]) {
                        temp.add(adj);
                        visited[adj] = true;
                    }
                }
            }

            if (temp.isEmpty()) break;
            queue.addAll(temp);
            cnt = temp.size();
        }

        return cnt;
    }

    /**
     * 문제 설명
     * n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
     *
     * 처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다.
     * 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다.
     * 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
     *
     * 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
     *
     * 입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때, 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * 입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
     * 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
     * 심사관은 1명 이상 100,000명 이하입니다.
     * 입출력 예
     * n	times	return
     * 6	[7, 10]	28
     * 입출력 예 설명
     * 가장 첫 두 사람은 바로 심사를 받으러 갑니다.
     *
     * 7분이 되었을 때, 첫 번째 심사대가 비고 3번째 사람이 심사를 받습니다.
     *
     * 10분이 되었을 때, 두 번째 심사대가 비고 4번째 사람이 심사를 받습니다.
     *
     * 14분이 되었을 때, 첫 번째 심사대가 비고 5번째 사람이 심사를 받습니다.
     *
     * 20분이 되었을 때, 두 번째 심사대가 비지만 6번째 사람이 그곳에서 심사를 받지 않고 1분을 더 기다린 후에 첫 번째 심사대에서 심사를 받으면 28분에 모든 사람의 심사가 끝납니다.
     * @param n
     * @param times
     * @return
     */
    public long solution2(int n, int[] times) {
        long answer = 0;

        return answer;
    }
}
