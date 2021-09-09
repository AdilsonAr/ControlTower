package com.controltower.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WindDirection {

    protected static String getWindDirection(int windDegree) {
        switch (windDegree) {
            case WindDegree.NORTH_DEGREE:
                return "north";
            case WindDegree.EAST_DEGREE:
                return "east";
            case WindDegree.SOUTH_DEGREE:
                return "south";
            case WindDegree.WEST_DEGREE:
                return "west";
            default:
                if (isNorthEast(windDegree)) return "north east";
                if (isSouthEast(windDegree)) return "south east";
                if (isSouthWest(windDegree)) return "south west";
                if (isNorthWest(windDegree)) return "north west";
                else return "error: out of range";
        }
    }

    private static boolean isNorthEast(int windDegree) {
        return windDegree > WindDegree.NORTH_DEGREE && windDegree < WindDegree.EAST_DEGREE;
    }

    private static boolean isSouthEast(int windDegree) {
        return windDegree > WindDegree.EAST_DEGREE && windDegree < WindDegree.SOUTH_DEGREE;
    }

    private static boolean isSouthWest(int windDegree) {
        return windDegree > WindDegree.SOUTH_DEGREE && windDegree < WindDegree.WEST_DEGREE;
    }

    private static boolean isNorthWest(int windDegree) {
        return windDegree > WindDegree.WEST_DEGREE && windDegree < WindDegree.LIMIT_DEGREE;
    }

}
