// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.utilities.procedural;

/**
 * Computes Brownian noise based on some noise generator.
 * Originally, Brown integrates white noise, but using other noises can be sometimes useful, too.
 * @deprecated Use {@link BrownianNoise} instead and adjust the scale factor: the new impl. returns [-1..1].
 */
@Deprecated
public class BrownianNoise3D extends BrownianNoiseOld implements Noise3D {

    private final Noise3D other;

    /**
     * Uses the default number of octaves
     * @param other the noise to use as a basis
     */
    public BrownianNoise3D(Noise3D other) {
        this.other = other;
    }

    /**
     * @param octaves the number of octaves to use
     */
    public BrownianNoise3D(Noise3D other, int octaves) {
        this(other);
        setOctaves(octaves);
    }

    /**
     * Returns Fractional Brownian Motion at the given position.
     *
     * @param x Position on the x-axis
     * @param y Position on the y-axis
     * @param z Position on the z-axis
     * @return The noise value in the range [-getScale()..getScale()]
     */
    @Override
    public float noise(float x, float y, float z) {
        float result = 0.0f;

        float workingX = x;
        float workingY = y;
        float workingZ = z;
        for (int i = 0; i < getOctaves(); i++) {
            result += other.noise(workingX, workingY, workingZ) * (float) getSpectralWeight(i);

            workingX *= (float) getLacunarity();
            workingY *= (float) getLacunarity();
            workingZ *= (float) getLacunarity();
        }

        return result;
    }

}
