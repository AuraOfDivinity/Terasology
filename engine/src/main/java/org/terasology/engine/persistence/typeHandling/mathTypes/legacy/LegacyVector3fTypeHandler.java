// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.persistence.typeHandling.mathTypes.legacy;

import gnu.trove.list.TFloatList;
import org.terasology.math.geom.Vector3f;
import org.terasology.engine.persistence.typeHandling.PersistedData;
import org.terasology.engine.persistence.typeHandling.PersistedDataArray;
import org.terasology.engine.persistence.typeHandling.PersistedDataSerializer;

import java.util.Optional;

/**
 */
public class LegacyVector3fTypeHandler extends org.terasology.engine.persistence.typeHandling.TypeHandler<Vector3f> {

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
