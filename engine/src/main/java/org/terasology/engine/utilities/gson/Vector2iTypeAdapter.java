// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.utilities.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.joml.Vector2i;

import java.lang.reflect.Type;

/**
 */
public class Vector2iTypeAdapter implements JsonDeserializer<Vector2i> {
    @Override
    public Vector2i deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray jsonArray = json.getAsJsonArray();
        return new Vector2i(jsonArray.get(0).getAsInt(), jsonArray.get(1).getAsInt());
    }
}
