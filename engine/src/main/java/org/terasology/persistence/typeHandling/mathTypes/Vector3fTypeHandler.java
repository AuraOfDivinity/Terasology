/*
 * Copyright 2020 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.persistence.typeHandling.mathTypes;

import gnu.trove.list.TFloatList;
import org.joml.Vector3f;
import org.terasology.persistence.typeHandling.PersistedData;
import org.terasology.persistence.typeHandling.PersistedDataArray;
import org.terasology.persistence.typeHandling.PersistedDataSerializer;
import org.terasology.persistence.typeHandling.TypeHandler;

import java.util.Optional;

/**
 */
public class Vector3fTypeHandler extends TypeHandler<Vector3f> {

    @Override
    public PersistedData serializeNonNull(Vector3f value, PersistedDataSerializer serializer) {
        return serializer.serialize(value.x, value.y, value.z);
    }

    @Override
    public Optional<Vector3f> deserialize(PersistedData data) {
        if (data.isArray()) {
            PersistedDataArray dataArray = data.getAsArray();
            if (dataArray.isNumberArray() && dataArray.size() > 2) {
                TFloatList floats = dataArray.getAsFloatArray();
                return Optional.of(new Vector3f(floats.get(0), floats.get(1), floats.get(2)));
            }
        }
        return Optional.empty();
    }
}
