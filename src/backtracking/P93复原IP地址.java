package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
示例:
输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
 */
public class P93复原IP地址 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12){
            return res;
        }
        Deque<String> track = new ArrayDeque<>();
        int numSeg = 4;
        backtrack(0, s, track, numSeg);
        return res;

    }

    private void backtrack(int start, String s, Deque<String> track, int numSeg) {
        //递归终止条件
        if (start == s.length() && numSeg == 0){
            res.add(String.join(".", track));
        }

        // 循环递归
        for (int i = start; i < start + 3; i++){
            // 剪枝情况
            if (i == s.length()){
                break;
            }
            if (numSeg * 3 < s.length() - i){
                continue;
            }

            // 做出有效选择
            if (isVaildIpSegment(s, start, i + 1)){
                // 取出当前片段
                String seg = s.substring(start, i + 1);
                // 选择
                track.addLast(seg);
                // 递归
                backtrack(i + 1, s, track, numSeg - 1);
                // 取消选择
                track.removeLast();
            }
        }
    }

    // 左闭右开
    private boolean isVaildIpSegment(String s, int start, int end) {
        // 判断一下， 多长度的字符串，第一个数字为0的情况进行排除 比如001;
        if (end - start > 1 && s.charAt(start) == '0'){
            return false;
        }
        String substring = s.substring(start, end);
        int value = Integer.parseInt(substring);
        return value >= 0 && value <= 255;
    }

    class ans0{
        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            StringBuilder ip = new StringBuilder();

            for (int a = 1; a < 4; a++) {
                for (int b = 1; b < 4; b++) {
                    for (int c = 1; c < 4; c++) {
                        for (int d = 1; d < 4; d++) {
//
//                          1、保障下面subString不会越界
//                          2、保障截取的字符串与输入字符串长度相同
//                          //1、2比较好理解，3比较有意思
//                          3、不能保障截取的字符串转成int后与输入字符串长度相同
//                          如：字符串010010，a=1，b=1，c=1，d=3，对应字符串0，1，0，010
//                          转成int后seg1=0，seg2=1，seg3=0，seg4=10
//                          //所以需要下面这处判断if (ip.length() == s.length() + 3)
//                         /
                            if (a + b + c + d == s.length()) {
                                // a b c d 分别为四小段的长度
                                int seg1 = Integer.parseInt(s.substring(0, a));
                                int seg2 = Integer.parseInt(s.substring(a, a + b));
                                int seg3 = Integer.parseInt(s.substring(a + b, a + b + c));
                                int seg4 = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
                                // 四个段数值满足0~255
                                if (seg1 <= 255 && seg2 <= 255 && seg3 <= 255 && seg4 <= 255) {
                                    ip.append(seg1).append(".").append(seg2).append(".").
                                            append(seg3).append(".").append(seg4);

                                    // 保障截取的字符串转成int后与输入字符串长度相同

                                    if (ip.length() == s.length() + 3) {
                                        result.add(ip.toString());
                                    }
                                    // 清空ip
                                    // delete(int start, int end)
                                    ip.delete(0, ip.length());
                                }
                            }
                        }
                    }
                }
            }
            return result;
        }
    }

    class ans1{
        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            List<String> res = new ArrayList<>();
            if (len > 12 || len < 4) {
                return res;
            }

            Deque<String> path = new ArrayDeque<>(4);
            dfs(s, len, 0, 4, path, res);
            return res;
        }

        // 需要一个变量记录 residue 剩余多少段还没被分割

        private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
            // 递归结束条件 索引到达最后位置
            // 且子段数 满足四段要求
            if (begin == len) {
                if (residue == 0) {
                    res.add(String.join(".", path));
                }
                return;
            }

            // 循环递归
            for (int i = begin; i < begin + 3; i++) {
                // 剪枝 通过break和continue以及return来剪枝
                // 情况一 索引超界
                if (i >= len) {
                    break;
                }
                // 情况二 剩下的字符过长
                if (residue * 3 < len - i) {
                    continue;
                }

                // 进行相应合理选择
                if (judgeIpSegment(s, begin, i)) {
                    String currentIpSegment = s.substring(begin, i + 1);
                    // 把ArrayDeque当做一个栈使用
                    // 选择
                    path.addLast(currentIpSegment);
                    // 下一步递归
                    dfs(s, len, i + 1, residue - 1, path, res);
                    // 取消选择
                    path.removeLast();
                }
            }
        }

        // 判断 ip 子段是否符合要求
        private boolean judgeIpSegment(String s, int left, int right) {
            int len = right - left + 1;
            if (len > 1 && s.charAt(left) == '0') {
                return false;
            }

            int res = 0;
            while (left <= right) {
                res = res * 10 + s.charAt(left) - '0';
                left++;
            }

            return res >= 0 && res <= 255;
        }
    }


}
