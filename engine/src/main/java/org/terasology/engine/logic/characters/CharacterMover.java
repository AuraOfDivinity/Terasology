// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.logic.characters;

import org.terasology.engine.entitySystem.entity.EntityRef;

/**
 * A CharacterMover is responsible for calculating character movement and generating related events. The events that can
 * be generated by movement include:
 * <ul>
 * <li> OnEnterLiquidEvent </li>
 * <li> OnLeaveLiquidEvent </li>
 * <li> MovedEvent </li>
 * <li> VerticalCollisionEvent </li>
 * <li> FootstepEvent </li>
 * <li> SwimStrokeEvent </li>
 * <li> JumpEvent </li>
 * <li> HorizontalCollisionEvent </li>
 * </ul>
 */
@FunctionalInterface
public interface CharacterMover {

    /**
     * Calculate the new state of a character based on the previous state and the input. Note that input is not always
     * player input. Input can also be for an AI character.
     *
     * @param initial The initial state to start from
     * @param input The input driving the movement change
     * @param entity The character
     * @return The new state of the character
     */
    CharacterStateEvent step(CharacterStateEvent initial, CharacterMoveInputEvent input, EntityRef entity);

}
