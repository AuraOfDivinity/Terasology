// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.logic.players;

import org.terasology.engine.input.BindButtonEvent;
import org.terasology.engine.input.DefaultBinding;
import org.terasology.engine.input.RegisterBindButton;
import org.terasology.nui.input.ActivateMode;
import org.terasology.nui.input.InputType;
import org.terasology.nui.input.Keyboard;

/**
 *
 */
@RegisterBindButton(id = "increaseViewDistance", description = "${engine:menu#binding-increase-view-distance}", mode 
        = ActivateMode.PRESS, category = "general")
@DefaultBinding(type = InputType.KEY, id = Keyboard.KeyId.HOME)
public class IncreaseViewDistanceButton extends BindButtonEvent {
}
