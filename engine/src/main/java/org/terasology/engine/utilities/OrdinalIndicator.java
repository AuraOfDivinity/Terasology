// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.utilities;

import org.terasology.gestalt.module.sandbox.API;

/**
 *         Contains functions to get the ordinal indicator string for an integer.
 */
@API
public final class OrdinalIndicator {

    private OrdinalIndicator() {
    }

    /**
     * Returns the ordinal indicator of an integer.
     * <br><br>
     * Most readable when called with class name:
     * OrdinalIndicator.of(22) returns "nd"
     *
     * @param number the integer
     * @return The ordinal indicator ("st", "nd", "rd" or "th").
     */
    public static String of(int number) {
        int x = Math.abs(number);
        x %= 100;

        switch (x) {
            case 11:
            case 12:
            case 13:
                return "th";
        }

        x %= 10;

        switch (x) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    /**
     * Returns the integer combined with it's ordinal indicator as String.
     * <br><br>
     * Most readable when called with class name:
     * OrdinalIndicator.addedTo(22) returns "22nd"
     *
     * @param x the integer
     * @return The integer with it's ordinal indicator attached.
     */
    public static String addedTo(int x) {
        return String.format("%d%s", x, OrdinalIndicator.of(x));
    }
}
