// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.world.generation.facets;

import org.terasology.engine.math.Region3i;
import org.terasology.engine.world.generation.Border3D;
import org.terasology.engine.world.generation.facets.base.BaseBooleanFieldFacet3D;
import org.terasology.engine.world.generation.facets.base.BooleanFieldFacet3D;

/**
 * Tests the {@link BaseBooleanFieldFacet3D} class.
 */
public class BaseBooleanFacetTest extends BooleanFacetTest {

    @Override
    protected BooleanFieldFacet3D createFacet(Region3i region, Border3D border) {
        return new BaseBooleanFieldFacet3D(region, border) {
            // this class is abstract, but we don't want specific implementations
        };
    }


}
