// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.logic.characters;

import org.terasology.engine.entitySystem.Component;
import org.terasology.engine.network.Replicate;

/**
 * This is only attached to the <b>alive character</b> entities. <br/> Used to differentiate between alive and dead
 * character entities.<br/><br/>
 * <p>
 * This needs to be necessarily attached to all character entities that require CharacterMovementComponent for movement
 * systems to work.<br/> Can be used to differently handle situations for character entities that can remain in a dead
 * state or respawn after a while.
 */
@Replicate
public class AliveCharacterComponent implements Component {
}
