// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.persistence.typeHandling.inMemory;

/**
 */
public class PersistedBoolean extends AbstractPersistedData {
    private final boolean data;

    public PersistedBoolean(boolean data) {
        this.data = data;
    }

    @Override
    public boolean getAsBoolean() {
        return data;
    }

    @Override
    public boolean isBoolean() {
        return true;
    }
}
