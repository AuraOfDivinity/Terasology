// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.input.cameraTarget;

import org.terasology.engine.entitySystem.event.Event;

/**
 * Event when the camera ceases to be over an entity - sent to the involved entity
 */
public class CameraOutEvent implements Event {

    public CameraOutEvent() {
    }
}
