package com.r948.utilities;

public class StringUtil {

    /**
     * 判断内容是否为空
     *
     * @param values string
     * @return true or false
     */
    public static boolean haveNullOrEmpty(String... values) {
        for (String value : values) if (value == null || "".equals(value)) return true;
        return false;
    }
}
