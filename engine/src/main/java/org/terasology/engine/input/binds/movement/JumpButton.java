// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.input.binds.movement;

import org.terasology.engine.input.BindButtonEvent;
import org.terasology.engine.input.DefaultBinding;
import org.terasology.engine.input.RegisterBindButton;
import org.terasology.nui.input.ControllerId;
import org.terasology.nui.input.InputType;
import org.terasology.nui.input.Keyboard;

/**
 *
 */
@RegisterBindButton(id = "jump", description = "${engine:menu#binding-jump}", repeating = false)
@DefaultBinding(type = InputType.KEY, id = Keyboard.KeyId.SPACE)
@DefaultBinding(type = InputType.CONTROLLER_BUTTON, id = ControllerId.TWO)
public class JumpButton extends BindButtonEvent {
}
