package io.kofo.common;

/**
 * author: fanyongpeng
 * date: 2019/2/22
 **/
public class Assert {
    public static <T> T  notNull(T t) {
        if (t == null) {
            error();
        }
        return t;
    }

    public static <T> T  notNull(T t, String message) {
        if (t == null) {
            error(message);
        }
        return t;
    }

    public static String notBlank(String str) {
        if (str == null || "".equals(str)) {
            error();
        }
        return str;
    }

    public static String notBlank(String str, String message) {
        if (str == null || "".equals(str)) {
            error(message);
        }
        return str;
    }


    public static void error() {
        throw new AssertionError();
    }

    public static void error(String error) {
        throw new AssertionError(error);
    }
}
