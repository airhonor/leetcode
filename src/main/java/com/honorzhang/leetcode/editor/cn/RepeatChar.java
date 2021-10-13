package com.honorzhang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @author: zgr
 * @create: 2021-10-11 23:33
 * 在一个给定的字符串中，找出连续相同的字符分组，每组字符都不相同，并给每组字符加入在本组字符中的顺序，从1开始
 * 给定aabbcdddfffffff 输出a1a2b1b2c1d1d2d3f1f2f3f4f5f6f7
 * 给定q 输出q1
 * 给定qwe 输出q1w1e1
 **/
public class RepeatChar {

    public static void main(String[] args) {

        List<String> input = new ArrayList<>(16);
        input.add("");
        input.add("a");
        input.add("qwe");
        input.add("aabbcdddfffffff");
        input.add("jyhgggue");
        input.add("aaaaaaaa");
        for (String s : input) {
            System.out.println(repeatChar(s));
        }
    }


    public static String repeatChar(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < len; i++) {
            //后一个字符与前一个字符不相同
            if (s.charAt(i - 1) != s.charAt(i)) {
                for (int j = 0; j < i - index; j++) {
                    sb.append(s.charAt(index + j)).append(j + 1);
                }
                index = i;
            }
        }
        //最后一组字符需要单独添加
        for (int i = 0; i < len - index; i++) {
            sb.append(s.charAt(index + i)).append(i + 1);
        }
        return sb.toString();
    }
}
