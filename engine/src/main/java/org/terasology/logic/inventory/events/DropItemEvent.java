/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.logic.inventory.events;

import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.terasology.entitySystem.event.Event;
import org.terasology.network.ServerEvent;

/**
 * Fire this event on an item in order for the authority to add the necessary components to put it in the world.
 */
@ServerEvent
public class DropItemEvent implements Event {
    private Vector3f position = new Vector3f();

    public DropItemEvent() {
    }

    public DropItemEvent(Vector3fc position) {
        this.position.set(position);
    }

    public Vector3fc getPosition() {
        return position;
    }
}
