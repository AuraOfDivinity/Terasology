// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.logic.characters.events;

import org.terasology.engine.entitySystem.event.Event;
import org.terasology.engine.world.block.Block;

/**
 * This event is sent when a character moves far enough to trigger a swim stroke (similar to a footstep on land)
 */
public class SwimStrokeEvent implements Event {
    private final Block liquid;

    public SwimStrokeEvent(Block liquid) {
        this.liquid = liquid;
    }

    public Block getLiquid() {
        return liquid;
    }
}
