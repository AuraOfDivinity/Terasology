// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.world.internal;

import org.joml.Vector3ic;
import org.terasology.engine.world.ChunkView;
import org.terasology.math.geom.Vector3i;

public interface ChunkViewCore extends ChunkView {

    /**
     * Sets the light level at the given position. the value is usually bounded by {@link
     * org.terasology.world.chunks.ChunkConstants#MAX_LIGHT}
     *
     * @param pos The position relative to the corner of the chunk
     * @param light set the light value of a block.
     * @deprecated This is scheduled for removal in an upcoming version method will be replaced with JOML implementation
     *         {@link #setLight(Vector3ic, byte)}.
     */
    @Deprecated
    void setLight(Vector3i pos, byte light);

    /**
     * Sets the light level at the given position. the value is usually bounded by {@link
     * org.terasology.world.chunks.ChunkConstants#MAX_LIGHT}
     *
     * @param pos The position relative to the corner of the chunk
     * @param light set the light value of a block.
     */
    void setLight(Vector3ic pos, byte light);

    /**
     * Sets the light level at the given coordinates. the value is usually bounded by {@link
     * org.terasology.world.chunks.ChunkConstants#MAX_LIGHT}
     *
     * @param blockX X offset from the corner of the chunk
     * @param blockY Y offset from the corner of the chunk
     * @param blockZ Z offset from the corner of the chunk
     * @param light set the light value of a block.
     */
    void setLight(int blockX, int blockY, int blockZ, byte light);

    /**
     * Sets the sunlight level at the given position. the value is usually bounded by {@link
     * org.terasology.world.chunks.ChunkConstants#MAX_SUNLIGHT}
     *
     * @param pos The position relative to the corner of the chunk
     * @param light set the sunlight light value of a block.
     * @deprecated This is scheduled for removal in an upcoming version method will be replaced with JOML implementation
     *         {@link #setSunlight(Vector3ic, byte)}.
     */
    @Deprecated
    void setSunlight(Vector3i pos, byte light);


    /**
     * Sets the sunlight level at the given position. the value is usually bounded by {@link
     * org.terasology.world.chunks.ChunkConstants#MAX_SUNLIGHT}
     *
     * @param pos The position relative to the corner of the chunk
     * @param light set the sunlight light value of a block.
     */
    void setSunlight(Vector3ic pos, byte light);


    /**
     * Sets the sunlight level at the given coordinates. the value is usually bounded by {@link
     * org.terasology.world.chunks.ChunkConstants#MAX_SUNLIGHT}
     *
     * @param blockX X offset from the corner of the chunk
     * @param blockY Y offset from the corner of the chunk
     * @param blockZ Z offset from the corner of the chunk
     * @param light set the sunlight light value of a block.
     */
    void setSunlight(int blockX, int blockY, int blockZ, byte light);

}
