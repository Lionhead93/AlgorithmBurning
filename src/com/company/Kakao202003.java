package com.company;

import java.util.*;
import java.util.stream.Collectors;

class Developer {
    String language;
    String major;
    String career;
    String food;
    int score;

    public Developer(String language, String major, String career, String food, int score) {
        this.language = language;
        this.major = major;
        this.career = career;
        this.food = food;
        this.score = score;
    }
}

public class Kakao202003 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Developer[] developers = new Developer[info.length];
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            developers[i] = new Developer(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]));
        }
        Developer[] conditions = new Developer[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].split(" and ");
            conditions[i] = new Developer(split[0], split[1], split[2], split[3].split(" ")[0], Integer.parseInt(split[3].split(" ")[1]));
        }
        for (int i = 0; i < conditions.length; i++) {
            int cnt = 0;
            for (Developer developer : developers) {
                if ((conditions[i].career.equals("-") || developer.career.equals(conditions[i].career)) &&
                        (conditions[i].major.equals("-") || developer.major.equals(conditions[i].major)) &&
                        (conditions[i].language.equals("-") || developer.language.equals(conditions[i].language)) &&
                        (conditions[i].food.equals("-") || developer.food.equals(conditions[i].food)) &&
                        developer.score >= conditions[i].score) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public int[] solution2(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[][] developers = new String[info.length][5];
        for (int i = 0; i < info.length; i++) {
            developers[i] = info[i].split(" ");
        }
        String[][] conditions = new String[query.length][5];
        for (int i = 0; i < query.length; i++) {
            String[] condition = query[i].split(" and ");
            conditions[i][0] = condition[0];
            conditions[i][1] = condition[1];
            conditions[i][2] = condition[2];
            conditions[i][3] = condition[3].split(" ")[0];
            conditions[i][4] = condition[3].split(" ")[1];
        }
        for (int i = 0; i < conditions.length; i++) {
            int cnt = 0;
            for (String[] developer : developers) {
                if ((conditions[i][0].equals("-") || developer[0].equals(conditions[i][0])) &&
                        (conditions[i][1].equals("-") || developer[1].equals(conditions[i][1])) &&
                        (conditions[i][2].equals("-") || developer[2].equals(conditions[i][2])) &&
                        (conditions[i][3].equals("-") || developer[3].equals(conditions[i][3])) &&
                        Integer.parseInt(developer[4]) >= Integer.parseInt(conditions[i][4])) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public int[] solution3(String[] info, String[] query) {
        int[] answer = new int[query.length];

        Map<String, List<Integer>> devMap = new HashMap<>();
        for(String s : info){
            List<Integer> orDefault = devMap.getOrDefault(s.substring(0, s.length() - 3), new ArrayList<>());
            orDefault.add(Integer.parseInt(s.substring(s.length()-3, s.length())));
        }



        return answer;
    }

    public static void main(String[] args) {
        String s = "java and backend and junior and pizza 100";
        System.out.println(s.substring(0,s.length()-3));
        System.out.println(s.substring(s.length()-3, s.length()));
    }
}
