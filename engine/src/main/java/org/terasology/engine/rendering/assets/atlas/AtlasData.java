// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.rendering.assets.atlas;

import org.terasology.gestalt.assets.AssetData;
import org.terasology.gestalt.naming.Name;
import org.terasology.engine.rendering.assets.texture.subtexture.SubtextureData;

import java.util.Map;

/**
 */
public class AtlasData implements AssetData {

    private final Map<Name, SubtextureData> subtextures;

    public AtlasData(Map<Name, SubtextureData> subtextureMap) {
        this.subtextures = subtextureMap;
    }

    public Map<Name, SubtextureData> getSubtextures() {
        return subtextures;
    }
}
