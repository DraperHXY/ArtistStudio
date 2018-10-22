package com.draper;

import java.util.Date;

public class TimeUtil {

    public static long getNowTimeAsLong() {
        return new Date().getTime();
    }

}
