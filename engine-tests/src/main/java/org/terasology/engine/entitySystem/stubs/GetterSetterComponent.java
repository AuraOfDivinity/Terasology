// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.entitySystem.stubs;

import org.terasology.engine.entitySystem.Component;
import org.terasology.math.geom.Vector3f;

/**
 *
 */
public class GetterSetterComponent implements Component {
    public transient boolean getterUsed;
    public transient boolean setterUsed;

    private Vector3f value = new Vector3f(0, 0, 0);

    public Vector3f getValue() {
        getterUsed = true;
        return value;
    }

    public void setValue(Vector3f value) {
        this.value = value;
        setterUsed = true;
    }
}
