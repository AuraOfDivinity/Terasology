// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.input.binds.general;

import org.terasology.engine.input.BindButtonEvent;
import org.terasology.engine.input.DefaultBinding;
import org.terasology.engine.input.RegisterBindButton;
import org.terasology.nui.input.ControllerId;
import org.terasology.nui.input.InputType;
import org.terasology.nui.input.Keyboard;

@RegisterBindButton(id = "pause", description = "${engine:menu#binding-pause}", category = "general")
@DefaultBinding(type = InputType.KEY, id = Keyboard.KeyId.ESCAPE)
@DefaultBinding(type = InputType.CONTROLLER_BUTTON, id = ControllerId.SEVEN)  // Button 9 for PlayStation Controllers
public class PauseButton extends BindButtonEvent {
}
