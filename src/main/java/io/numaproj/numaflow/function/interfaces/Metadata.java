package io.numaproj.numaflow.function.interfaces;

/**
 * Metadata contains methods to get the metadata for the reduce operation.
 */
public interface Metadata {
    /**
     * method to get the interval window.
     * @return IntervalWindow which has the window information
     */
    IntervalWindow getIntervalWindow();
}

