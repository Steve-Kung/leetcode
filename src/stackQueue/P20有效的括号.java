package stackQueue;

import java.util.HashMap;
import java.util.Stack;

public class P20有效的括号 {

    // 跟括号顺序有关的问题，一般都可以采用栈这种数据结构
    public boolean isValid(String s) {
        if (s.length() % 2 == 1){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '[' || c == '(' || c == '{'){
                stack.push(c);
            }
            if (c == ']' || c == ')' || c == '}'){
                if (!stack.isEmpty()){
                    char pop = stack.pop();
                    if (map.get(pop) != c){
                        return false;
                    }
                } else {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
