// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.rendering.nui.layers.ingame;

import org.terasology.engine.core.GameEngine;
import org.terasology.engine.core.modes.StateMainMenu;
import org.terasology.engine.logic.players.LocalPlayer;
import org.terasology.engine.logic.players.event.RespawnRequestEvent;
import org.terasology.engine.registry.CoreRegistry;
import org.terasology.engine.rendering.nui.CoreScreenLayer;
import org.terasology.nui.WidgetUtil;
import org.terasology.nui.widgets.UILabel;

/**
 * This screen is displayed when the player dies.
 */
public class DeathScreen extends CoreScreenLayer {
    private UILabel deathDetails;

    @Override
    protected boolean isEscapeToCloseAllowed() {
        return false;
    }

    @Override
    public void initialise() {
        deathDetails = find("deathDetails", UILabel.class);
        WidgetUtil.trySubscribe(this, "respawn", widget -> {
            CoreRegistry.get(LocalPlayer.class).getClientEntity().send(new RespawnRequestEvent());
            getManager().closeScreen(DeathScreen.this);
        });
        WidgetUtil.trySubscribe(this, "settings", widget -> getManager().pushScreen("settingsMenuScreen"));
        WidgetUtil.trySubscribe(this, "mainMenu", widget -> {
            CoreRegistry.get(LocalPlayer.class).getClientEntity().send(new RespawnRequestEvent());
            CoreRegistry.get(GameEngine.class).changeState(new StateMainMenu());
        });
        WidgetUtil.trySubscribe(this, "exitGame", widget -> CoreRegistry.get(GameEngine.class).shutdown());
    }

    public void setDeathDetails(String instigatorName, String damageTypeName) {
        if (instigatorName != null) {
            deathDetails.setText(String.format("%s killed you with %s.", instigatorName, damageTypeName));
        } else {
            deathDetails.setText(String.format("You died to %s.", damageTypeName));
        }
    }

    @Override
    public boolean isLowerLayerVisible() {
        return false;
    }
}
