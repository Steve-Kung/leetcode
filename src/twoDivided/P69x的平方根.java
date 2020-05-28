package twoDivided;
/*
实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
 */
public class P69x的平方根 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        int left = 0;
        int right = x;
        while (left < right){
            int mid = left + (right - left)/2;
            int sqrt = x / mid;
            if (sqrt < mid){
                right = mid;
            } else if (sqrt > mid){
                left = mid + 1;
            } else if (sqrt == mid){
                return mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        P69x的平方根 p69x的平方根 = new P69x的平方根();
        p69x的平方根.mySqrt(8);
    }
}
