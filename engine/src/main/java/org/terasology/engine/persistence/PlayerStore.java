// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.persistence;

import org.terasology.engine.entitySystem.entity.EntityRef;
import org.terasology.math.geom.Vector3f;

/**
 */
public interface PlayerStore {

    /**
     * @return The id of this store
     */
    String getId();

    /**
     * Restores all entities contained in this store, activating them.
     */
    void restoreEntities();

    /**
     * Stores the character
     *
     * @param character
     */
    void setCharacter(EntityRef character);

    /**
     * Retrieves the player's character entity
     *
     * @return The restored character's EntityRef
     */
    EntityRef getCharacter();

    /**
     * Sets the location which should be loaded for the player when they rejoin the game.
     * <br><br>
     * This is set automatically to the character's location if a character is stored.
     *
     * @param location
     */
    void setRelevanceLocation(Vector3f location);

    /**
     * @return The location that is the center of the area relevant for the player.
     */
    Vector3f getRelevanceLocation();

    /**
     * @return Whether the player has a character or not
     */
    boolean hasCharacter();


}
