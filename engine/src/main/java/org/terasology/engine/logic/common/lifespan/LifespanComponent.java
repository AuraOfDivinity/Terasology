// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.logic.common.lifespan;

import org.terasology.engine.entitySystem.Component;
import org.terasology.engine.network.Replicate;

/**
 * Component describes the lifespan of an entity. When the lifespan ends the entity is destroyed.
 */
public class LifespanComponent implements Component {
    // Lifespan in seconds
    @Replicate
    public float lifespan = 5;
    @Replicate
    public long deathTime;

    public LifespanComponent() {
    }

    public LifespanComponent(float span) {
        this.lifespan = span;
    }
}
