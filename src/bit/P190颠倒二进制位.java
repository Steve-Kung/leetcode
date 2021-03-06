package bit;
// 颠倒给定的 32 位无符号整数的二进制位。
/*
输入: 00000010100101000001111010011100
输出: 00111001011110000010100101000000
解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。

 */
public class P190颠倒二进制位 {
    // 每一位先颠倒对调， 再搜集所有位数
    public int reverseBits(int n) {
        int ret = 0;
        for(int i = 31; i >= 0; i--) {
            ret = ret | (((n>>(31-i)) & 1) << i);
        }

        return ret;
    }
}
