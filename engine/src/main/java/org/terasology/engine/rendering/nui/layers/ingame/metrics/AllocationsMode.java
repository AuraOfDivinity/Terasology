// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.rendering.nui.layers.ingame.metrics;

import gnu.trove.map.TObjectDoubleMap;
import org.terasology.engine.monitoring.PerformanceMonitor;

/**
 */
final class AllocationsMode extends TimeMetricsMode {

    AllocationsMode() {
        super("\n- Memory Allocations -", 10, "bytes");
    }

    @Override
    protected TObjectDoubleMap<String> gatherMetrics() {
        return PerformanceMonitor.getAllocationMean();
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public boolean isPerformanceManagerMode() {
        return true;
    }
}
