// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.utilities.procedural;

/**
 * Computes Brownian noise based on some noise generator.
 * Originally, Brown integrates white noise, but using other noises can be sometimes useful, too.
 *
 * @deprecated Use {@link BrownianNoise} instead and adjust the scale factor: the new impl. returns [-1..1].
 */
@Deprecated
public class BrownianNoise2D extends BrownianNoiseOld implements Noise2D {

    private final Noise2D other;

    /**
     * Uses the default number of octaves
     *
     * @param other the noise to use as a basis
     */
    public BrownianNoise2D(Noise2D other) {
        this.other = other;
    }

    /**
     * @param octaves the number of octaves to use
     */
    public BrownianNoise2D(Noise2D other, int octaves) {
        this(other);
        setOctaves(octaves);
    }

    /**
     * Returns Fractional Brownian Motion at the given position.
     *
     * @param x Position on the x-axis
     * @param y Position on the y-axis
     * @return The noise value in the range [-getScale()..getScale()]
     */
    @Override
    public float noise(float x, float y) {
        float result = 0.0f;

        float workingX = x;
        float workingY = y;
        for (int i = 0; i < getOctaves(); i++) {
            result += other.noise(workingX, workingY) * (float) getSpectralWeight(i);

            workingX *= (float) getLacunarity();
            workingY *= (float) getLacunarity();
        }

        return result;
    }

}
