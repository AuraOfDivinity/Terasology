// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.network.events;

import org.terasology.engine.entitySystem.event.Event;
import org.terasology.engine.network.OwnerEvent;

/**
 * This event handles the ping from the server to all clients.
 */
@OwnerEvent
public class PingFromServerEvent implements Event {
}
