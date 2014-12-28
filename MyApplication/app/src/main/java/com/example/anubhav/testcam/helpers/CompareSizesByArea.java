package com.example.anubhav.testcam.helpers;

/**
 * Created by Anubhav on 28-12-2014.
 */

import android.util.Size;

import java.util.Comparator;

/**
 * Compares two {@code Size}s based on their areas.
 */
public class CompareSizesByArea implements Comparator<Size> {

    @Override
    public int compare(Size lhs, Size rhs) {
        // We cast here to ensure the multiplications won't overflow
        return Long.signum((long) lhs.getWidth() * lhs.getHeight() -
                (long) rhs.getWidth() * rhs.getHeight());
    }
}