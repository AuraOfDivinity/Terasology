// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.input.binds.movement;

import org.terasology.engine.input.BindButtonEvent;
import org.terasology.engine.input.DefaultBinding;
import org.terasology.engine.input.RegisterBindButton;
import org.terasology.nui.input.InputType;
import org.terasology.nui.input.Keyboard;

/**
 *
 */
@RegisterBindButton(id = "forwards", description = "${engine:menu#binding-forwards}")
@DefaultBinding(type = InputType.KEY, id = Keyboard.KeyId.W)
public class ForwardsButton extends BindButtonEvent {
}
