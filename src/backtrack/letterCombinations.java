package src.backtrack;

import java.util.*;

public class letterCombinations {
    // 1. 预处理映射表：下标即为数字，对应按键上的字符集合
    private static final String[] MAPPING = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        // 3. 核心设计点：预先分配一个固定长度 n 的字符数组作为“路径容器”
        // 这样做避免了使用 StringBuilder 频繁进行 append 和 delete 的开销
        char[] path=new char[n];
        // 4. 将字符串转为 char 数组传参，加速字符读取；从第 0 个数字开始深度优先搜索
        dfs(0,res,path,digits.toCharArray());
        return res;

    }

    private void dfs(int i, List<String> res, char[] path, char[] digits) {
        if (i == digits.length) {
            res.add(new String(path));
            return;
        }
        // 6. 状态转化：取出当前位置数字对应的字符集（如 '2' - '0' = 2，获取 "abc"）
        String letters=MAPPING[digits[i]-'0'];
        // 7. 遍历当前按键对应的所有可能字母（展开决策树分支）
        for (char c : letters.toCharArray()) {
            path[i] = c;
            dfs(i+1, res, path, digits);
        }
    }
}
