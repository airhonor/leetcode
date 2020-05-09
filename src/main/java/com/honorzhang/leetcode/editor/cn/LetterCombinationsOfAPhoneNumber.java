//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List; 

public class LetterCombinationsOfAPhoneNumber{
      public static void main(String[] args) {
           Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
           List<String> ls = solution.letterCombinations("234");
            ls.forEach(l -> System.out.println(l));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>(16);
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return Collections.emptyList();
        }
        HashMap<Character,char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        StringBuilder sb = new StringBuilder();
        backTrace(digits, 0, map, sb);
        return res;
        }

        private void backTrace(String digits, int depth, HashMap<Character, char[]> map, StringBuilder sb){
            if (depth == digits.length()){
                res.add(sb.toString());
                return;
            }
            char num = digits.charAt(depth);
            char[] letters = map.get(num);
            for (int i=0; i<letters.length; i++){
                char choice = letters[i];
                sb.append(choice);
                backTrace(digits, depth+1, map, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

