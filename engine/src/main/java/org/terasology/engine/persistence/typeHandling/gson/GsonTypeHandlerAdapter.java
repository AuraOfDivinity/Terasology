// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.persistence.typeHandling.gson;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.terasology.engine.persistence.typeHandling.TypeHandler;

import java.io.IOException;

/**
 * Adapts a {@link TypeHandler} as a Gson {@link TypeAdapter}. Instances of {@link GsonTypeHandlerAdapter},
 * when registered as type adapters in a {@link Gson} object, can be used to (de)serialize objects
 * to JSON (via Gson) with the rules specified by the {@link GsonTypeHandlerAdapter#typeHandler}.
 *
 * Since instances of {@link GsonTypeHandlerAdapter} require a {@link Gson} object and a
 * {@link TypeToken}, it is recommended to register {@link GsonTypeHandlerAdapter} type adapters as a
 * type adapter factory via a {@link com.google.gson.TypeAdapterFactory} like
 * {@link GsonTypeHandlerAdapterFactory}.
 */
public final class GsonTypeHandlerAdapter<T> extends TypeAdapter<T> {

    private final TypeHandler<T> typeHandler;
    private final JsonSerializer<T> serializer;
    private final JsonDeserializer<T> deserializer;
    private final Gson gson;
    private final TypeToken<T> typeToken;

    GsonTypeHandlerAdapter(TypeHandler<T> typeHandler,
                           Gson gson, TypeToken<T> typeToken) {
        this.typeHandler = typeHandler;

        this.serializer = (src, typeOfSrc, context) ->
                ((GsonPersistedData) typeHandler.serialize(src, new GsonPersistedDataSerializer()))
                .getElement();

        this.deserializer = (json, typeOfT, context) ->
                typeHandler.deserializeOrNull(new GsonPersistedData(json));

        this.gson = gson;
        this.typeToken = typeToken;
    }

    @Override
    public T read(JsonReader in) throws IOException {
        JsonElement value = Streams.parse(in);
        if (value.isJsonNull()) {
            return null;
        }

        return deserializer.deserialize(value, typeToken.getType(), null);
    }

    @Override
    public void write(JsonWriter out, T value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        JsonElement tree = serializer.serialize(value, typeToken.getType(), null);
        Streams.write(tree, out);
    }
}

