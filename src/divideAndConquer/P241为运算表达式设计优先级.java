package divideAndConquer;

import java.util.ArrayList;
import java.util.List;

/*
给定一个含有数字和运算符的字符串，为表达式添加括号，
改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。
有效的运算符号包含 +, - 以及 * 。
输入: "2-1-1"
输出: [0, 2]
解释:
((2-1)-1) = 0
(2-(1-1)) = 2
 */
public class P241为运算表达式设计优先级 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        int len = input.length();
        if (len == 0){
            return res;
        }
        int index = 0;
        int num = 0;
        //考虑是全数字的情况
        while (index < len && !isOperation(input.charAt(index))){
            num = num * 10 + (input.charAt(index) - '0');
            index++;
        }
        //将全数字的情况直接返回
        if (index == len){
            res.add(num);
            return res;
        }

        for (int i = 0; i< len; i++){
            //通过运算符将字符串分成两部分
            if (isOperation(input.charAt(i))){
                List<Integer> res1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(input.substring(i+1));
                //将两个结果依次运算
                for (int j = 0; j < res1.size(); j++) {
                    for (int k = 0; k < res2.size(); k++) {
                        char op = input.charAt(i);
                        res.add(cal(res1.get(j), op , res2.get(k)));
                    }
                }
            }
        }
        return res;
    }

    private int cal(int i, char op, int j) {
        switch (op){
            case '+':
                return i + j;
            case '-':
                return i - j;
            case '*':
                return i * j;
        }
        return -1;
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }


}

/*
public List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int num = 0;
        //考虑是全数字的情况
        int index = 0;
        while (index < input.length() && !isOperation(input.charAt(index))) {
            num = num * 10 + input.charAt(index) - '0';
            index++;
        }
        //将全数字的情况直接返回
        if (index == input.length()) {
            result.add(num);
            return result;
        }

        for (int i = 0; i < input.length(); i++) {
            //通过运算符将字符串分成两部分
            if (isOperation(input.charAt(i))) {
                List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
                //将两个结果依次运算
                for (int j = 0; j < result1.size(); j++) {
                    for (int k = 0; k < result2.size(); k++) {
                        char op = input.charAt(i);
                        result.add(caculate(result1.get(j), op, result2.get(k)));
                    }
                }
            }
        }
        return result;
    }

    private int caculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }
 */
