// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.logic.characters;

import org.terasology.engine.entitySystem.entity.EntityRef;
import org.terasology.engine.entitySystem.event.EventPriority;
import org.terasology.engine.entitySystem.event.ReceiveEvent;
import org.terasology.engine.entitySystem.systems.BaseComponentSystem;
import org.terasology.engine.entitySystem.systems.RegisterMode;
import org.terasology.engine.entitySystem.systems.RegisterSystem;
import org.terasology.engine.logic.characters.events.OnScaleEvent;
import org.terasology.engine.logic.characters.events.ScaleByRequest;
import org.terasology.engine.logic.characters.events.ScaleToRequest;

/**
 * Authority system to finally "accept" scaling requests.
 * <p>
 * Consumes scaling requests (either {@link ScaleByRequest} or {@link ScaleToRequest}) and sends out notifications about
 * the scaling event being "accepted" in form of {@link OnScaleEvent}. Systems should listen to that notification event
 * to act on character scaling.
 *
 * @see ScaleByRequest
 * @see ScaleToRequest
 * @see OnScaleEvent
 */
@RegisterSystem(RegisterMode.AUTHORITY)
public class CharacterScalingSystem extends BaseComponentSystem {

    @ReceiveEvent(priority = EventPriority.PRIORITY_TRIVIAL)
    public void onScaleByRequest(ScaleByRequest request, EntityRef entity,
                                 CharacterMovementComponent movementComponent) {
        OnScaleEvent scaleEvent = new OnScaleEvent(movementComponent.height,
                movementComponent.height * request.getFactor());
        entity.send(scaleEvent);
        request.consume();
    }

    @ReceiveEvent(priority = EventPriority.PRIORITY_TRIVIAL)
    public void onScaleToRequest(ScaleToRequest request, EntityRef entity,
                                 CharacterMovementComponent movementComponent) {
        OnScaleEvent scaleEvent = new OnScaleEvent(movementComponent.height, request.getTargetValue());
        entity.send(scaleEvent);
        request.consume();
    }
}
