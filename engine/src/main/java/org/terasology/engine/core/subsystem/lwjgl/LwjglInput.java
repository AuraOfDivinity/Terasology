// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.core.subsystem.lwjgl;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.terasology.engine.config.Config;
import org.terasology.engine.config.ControllerConfig;
import org.terasology.engine.context.Context;
import org.terasology.engine.core.modes.GameState;
import org.terasology.engine.core.subsystem.config.BindsManager;
import org.terasology.engine.input.InputSystem;
import org.terasology.engine.input.lwjgl.JInputControllerDevice;
import org.terasology.engine.input.lwjgl.LwjglKeyboardDevice;
import org.terasology.engine.input.lwjgl.LwjglMouseDevice;
import org.terasology.gestalt.assets.module.ModuleAwareAssetTypeManager;

public class LwjglInput extends BaseLwjglSubsystem {

    private Context context;

    @Override
    public String getName() {
        return "Input";
    }

    @Override
    public void registerCoreAssetTypes(ModuleAwareAssetTypeManager assetTypeManager) {
    }

    @Override
    public void postInitialise(Context rootContext) {
        this.context = rootContext;
        initControls();
        updateInputConfig();
        Mouse.setGrabbed(false);
    }

    @Override
    public void postUpdate(GameState currentState, float delta) {
        currentState.handleInput(delta);
    }

    @Override
    public void shutdown() {
        Mouse.destroy();
        Keyboard.destroy();
    }

    private void initControls() {
        try {
            Keyboard.create();
            Keyboard.enableRepeatEvents(true);
            Mouse.create();
            InputSystem inputSystem = new InputSystem();
            context.put(InputSystem.class, inputSystem);
            inputSystem.setMouseDevice(new LwjglMouseDevice(context));
            inputSystem.setKeyboardDevice(new LwjglKeyboardDevice());

            ControllerConfig controllerConfig = context.get(Config.class).getInput().getControllers();
            JInputControllerDevice controllerDevice = new JInputControllerDevice(controllerConfig);
            inputSystem.setControllerDevice(controllerDevice);
        } catch (LWJGLException e) {
            throw new RuntimeException("Could not initialize controls.", e);
        }
    }

    private void updateInputConfig() {
        BindsManager bindsManager = context.get(BindsManager.class);
        bindsManager.updateConfigWithDefaultBinds();
        bindsManager.saveBindsConfig();
    }
}
