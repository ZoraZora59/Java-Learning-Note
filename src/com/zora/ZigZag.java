package com.zora;

import java.util.ArrayList;
import java.util.List;

/**
 * ZigZag Z字抖动
 */
public class ZigZag {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int rows = 3;
        System.out.println(new ZigZag().convert(s, rows));
    }

    private String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] string = s.toCharArray();
        List<StringBuffer> stringBuffers = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            stringBuffers.add(new StringBuffer());
        }
        int row = 0;
        boolean zigOrZag = false;
        for (char x : string
        ) {
            stringBuffers.get(row).append(x);
            if (row == 0 || row == numRows - 1) {
                zigOrZag = !zigOrZag;
            }
            row += zigOrZag ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuffer buf : stringBuffers
        ) {
            ret.append(buf);
        }
        return ret.toString();
    }
}
