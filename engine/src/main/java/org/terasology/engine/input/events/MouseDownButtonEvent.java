// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.input.events;


import org.joml.Vector2i;
import org.terasology.nui.input.ButtonState;
import org.terasology.nui.input.MouseInput;

public class MouseDownButtonEvent extends MouseButtonEvent {

    private static final MouseDownButtonEvent event = new MouseDownButtonEvent(MouseInput.NONE, 0);

    protected MouseDownButtonEvent(MouseInput button, float delta) {
        super(button, ButtonState.DOWN, delta);
    }

    public static MouseDownButtonEvent create(MouseInput button, Vector2i mousePos, float delta) {
        event.reset(delta);
        event.setButton(button);
        event.setMousePosition(mousePos);
        return event;
    }
}
