// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.network.events;

import org.terasology.engine.entitySystem.event.Event;
import org.terasology.engine.persistence.PlayerStore;

/**
 * Event notifying that a new client has connected - sent against the client by the network system.
 *
 */
public class ConnectedEvent implements Event {

    private final PlayerStore playerStore;

    public ConnectedEvent(PlayerStore store) {
        this.playerStore = store;
    }

    /**
     * @return The PlayerStore for the connecting player. It is ready to restore any stored entities.
     */
    public PlayerStore getPlayerStore() {
        return playerStore;
    }

}
