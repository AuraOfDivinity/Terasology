// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.world.block.tiles;

import org.terasology.gestalt.assets.AssetData;

import java.awt.image.BufferedImage;

/**
 *
 */
public class TileData implements AssetData {
    private final BufferedImage[] images;
    private final boolean autoBlock;

    public TileData(BufferedImage[] images, boolean autoBlock) {
        this.images = images;
        this.autoBlock = autoBlock;
    }

    public BufferedImage[] getImages() {
        return images;
    }

    public boolean isAutoBlock() {
        return autoBlock;
    }
}
