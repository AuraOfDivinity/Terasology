// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.rendering.world;

import org.terasology.engine.world.chunks.RenderableChunk;

import java.util.PriorityQueue;

public class RenderQueuesHelper {
    public final PriorityQueue<RenderableChunk> chunksOpaque;
    public final PriorityQueue<RenderableChunk> chunksOpaqueShadow;
    public final PriorityQueue<RenderableChunk> chunksOpaqueReflection;
    public final PriorityQueue<RenderableChunk> chunksAlphaReject;
    public final PriorityQueue<RenderableChunk> chunksAlphaBlend;

    RenderQueuesHelper(PriorityQueue<RenderableChunk> chunksOpaque,
                       PriorityQueue<RenderableChunk> chunksOpaqueShadow,
                       PriorityQueue<RenderableChunk> chunksOpaqueReflection,
                       PriorityQueue<RenderableChunk> chunksAlphaReject,
                       PriorityQueue<RenderableChunk> chunksAlphaBlend) {

        this.chunksOpaque = chunksOpaque;
        this.chunksOpaqueShadow = chunksOpaqueShadow;
        this.chunksOpaqueReflection = chunksOpaqueReflection;
        this.chunksAlphaReject = chunksAlphaReject;
        this.chunksAlphaBlend = chunksAlphaBlend;
    }
}
