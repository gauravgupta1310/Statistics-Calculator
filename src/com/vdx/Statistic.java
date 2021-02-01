package com.vdx;

/**
 * Created by gupta.g on 31/01/21
 */
public class Statistic {
    int count = 0;
    float currentMean = 0;
    float currentVariance = 0;
    int currentMax = Integer.MIN_VALUE;
    int currentMin = Integer.MAX_VALUE;

    public synchronized void event(int value) {
        count++;


        float newMean = currentMean + ((value - currentMean)/count);
        float newVariance = currentVariance + (((float) value - newMean) * ((float) value - currentMean));


        // updating mean
        currentMean = newMean;

        // updating variance
        currentVariance = newVariance;

        // updating currentMax
        if (value > currentMax)
            currentMax = value;

        // updating currentMin
        if (value < currentMin)
            currentMin = value;
    }

    public float mean() {
        return currentMean;
    }

    // Not Implemented

    public float meanLastNMinutes(int lastNMinutes) {
        return 0;
    }

    public float variance() {
        return currentVariance / count;
    }

    public Integer maximum() {
        return currentMax;
    }

    public Integer minimum() {
        return currentMin;
    }


}
