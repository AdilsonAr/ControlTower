package com.controltower.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WindDegree {

    protected static final int NORTH_DEGREE = 0;
    protected static final int EAST_DEGREE = 90;
    protected static final int SOUTH_DEGREE = 180;
    protected static final int WEST_DEGREE = 270;
    protected static final int LIMIT_DEGREE = 360;

    protected static int getWindDegree(String windDirection) {
        return Integer.parseInt(windDirection.substring(0, windDirection.length() - 2));
    }

}
