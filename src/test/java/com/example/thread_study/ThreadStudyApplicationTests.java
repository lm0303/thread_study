package com.example.thread_study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

@SpringBootTest
class ThreadStudyApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str.charAt(1));
        System.out.println(str.substring(0,1));

        Deque<String> deque = new LinkedList<>();
        deque.offerFirst("A"); // A
        deque.offerFirst("B"); // A <- B
        deque.offerFirst("C"); // C <- A <- B
        System.out.println(deque.pollLast()); // C, 剩下A <- B

        List<String> res = new LinkedList<>(deque);
        System.out.println(res.get(0));
        StringJoiner joiner = new StringJoiner("->");
        for (String str1 : deque) {
            joiner.add(str1);
        }

        System.out.println(joiner.toString());
        System.out.println(String.join("->", deque));

        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {
            /**
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }

            public int compare(int a, int b) {
                // 降序排序
                return b - a;
            }
        });

        String sa = new String(1 + "" + 2),sb = new String(2 + "" + 1);
        int[] nums = new int[]{1,3,56};
        Arrays.sort(nums);
    }

}
