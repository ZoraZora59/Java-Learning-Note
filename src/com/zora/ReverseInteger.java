package com.zora;

/**
 * 回文数字
 *
 * @author zora
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int input = -2147483412;
        System.out.println(new ReverseInteger().reverse(input));
    }

    private int reverse(int x) {
        if (x > -10 && x < 10) {
            return x;
        }
        int ret = 0;
        while (x != 0) {
            int rest = x % 10;
            x /= 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && rest > 7)) {
                return 0;
            }
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && rest < -8)) {
                return 0;
            }
            ret = ret * 10 + rest;
        }
        return ret;
    }
}
