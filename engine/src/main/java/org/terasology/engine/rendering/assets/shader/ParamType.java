// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.rendering.assets.shader;

/**
 * TODO: write javadoc
 */
public enum ParamType {
    sampler2D(true),
    samplerCube(true);

    private final boolean texture;

    ParamType(boolean texture) {
        this.texture = texture;
    }

    public boolean isTexture() {
        return texture;
    }
}
