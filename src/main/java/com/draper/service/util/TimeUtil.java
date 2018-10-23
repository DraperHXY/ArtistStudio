package com.draper.service.util;

import java.util.Date;

public class TimeUtil {

    public static long getNowTimeAsLong() {
        return new Date().getTime();
    }

}
