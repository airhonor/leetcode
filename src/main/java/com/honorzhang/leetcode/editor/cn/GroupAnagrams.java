//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 760 👎 0


package com.honorzhang.leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> tempRes = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {

                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String key = String.copyValueOf(chars);
                if (tempRes.containsKey(key)) {
                    tempRes.get(key).add(strs[i]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    tempRes.put(key, list);
                }
            }
            List<List<String>> res = new ArrayList<>();
            for (List<String> lst : tempRes.values()) {
                res.add(lst);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}