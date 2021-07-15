package com.company;

import java.util.Arrays;

public class Day210715 {

    public int solution1(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }

    /**
     * 입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.
     * <p>
     * 1 <= m, n <= 100
     * picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
     * picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
     *
     * @param m
     * @param n
     * @param picture
     * @return
     */
    public int[] solution2(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || picture[i][j] == 0) {
                    continue;
                }
                numberOfArea++;
                maxSizeOfOneArea = Math.max(helper(visited, picture, i, j, m, n), maxSizeOfOneArea);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int helper(boolean[][] visited, int[][] picture, int i, int j, int m, int n) {

        int result = 0;

        if (visited[i][j] || picture[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;

        if (i < m - 1 && picture[i][j] == picture[i + 1][j]) {
            result += helper(visited, picture, i + 1, j, m, n);
        }
        if (i > 0 && picture[i][j] == picture[i - 1][j]) {
            result += helper(visited, picture, i - 1, j, m, n);
        }
        if (j < n - 1 && picture[i][j] == picture[i][j + 1]) {
            result += helper(visited, picture, i, j + 1, m, n);
        }
        if (j > 0 && picture[i][j] == picture[i][j - 1]) {
            result += helper(visited, picture, i, j - 1, m, n);
        }

        return 1 + result;
    }

    /**
     * 문제 설명
     * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
     * <p>
     * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     * <p>
     * 제한사항
     * 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
     * 주어진 공항 수는 3개 이상 10,000개 이하입니다.
     * tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
     * 주어진 항공권은 모두 사용해야 합니다.
     * 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
     * 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
     * 입출력 예
     * tickets	return
     * [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
     * [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
     * 입출력 예 설명
     * 예제 #1
     * <p>
     * ["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.
     * <p>
     * 예제 #2
     * <p>
     * ["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.
     *
     * @param tickets
     * @return
     */
    String[] answer;

    public String[] solution3(String[][] tickets) {

        String[] line = new String[tickets.length + 1];

        findNext(tickets, line, 0, "ICN");

        return answer;
    }

    private void findNext(String[][] tickets, String[] line, int size, String find) {

        if (size == tickets.length) {
            //update answer
            line[size] = find;
            regist(line);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(find)) {
                String[][] copyTickets = deepCopy(tickets);
                String[] copyLine = line.clone();
                copyLine[size] = find;
                copyTickets[i][0] = "";
                findNext(copyTickets, copyLine, size+1, tickets[i][1]);
            }
        }
    }

    private String[][] deepCopy(String[][] source) {
        if(source == null) return null;
        String[][] result = new String[source.length][source[0].length];

        for(int i=0; i<source.length; i++){
            result[i] = source[i].clone();
        }

        return result;
    }

    private void regist(String[] line) {
        if(answer==null) {
            answer = line;
            return;
        }
        for (int i = 0; i < line.length; i++) {
            if(line[i] != answer[i]) {
                if(line[i].compareTo(answer[i]) < 0) {
                    answer = line;
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("SFO".compareTo("ICN"));
    }
}
