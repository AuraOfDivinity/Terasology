/*
 * Copyright 2014 MovingBlocks
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
package org.terasology.world.block.structure;

import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.systems.BaseComponentSystem;
import org.terasology.entitySystem.systems.RegisterSystem;
import org.terasology.math.Side;
import org.terasology.math.Vector3i;
import org.terasology.registry.In;
import org.terasology.world.BlockEntityRegistry;
import org.terasology.world.WorldProvider;
import org.terasology.world.block.Block;
import org.terasology.world.block.BlockPart;
import org.terasology.world.block.shapes.BlockMeshPart;

import java.util.Collections;
import java.util.Map;

@RegisterSystem
public class AttachSupportRequiredSystem extends BaseComponentSystem implements BlockStructuralSupport {
    @In
    private BlockStructuralSupportRegistry registry;
    @In
    private WorldProvider worldProvider;
    @In
    private BlockEntityRegistry blockEntityRegistry;

    @Override
    public void preBegin() {
        registry.registerBlockStructuralSupport(this);
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public boolean shouldBeRemovedDueToChange(Vector3i location, Side sideChanged) {
        final SideBlockSupportRequiredComponent component = getComponent(location, Collections.<Vector3i, Block>emptyMap());
        if (component != null) {
            final Block block = getBlockWithOverrides(location, Collections.<Vector3i, Block>emptyMap());
            if (!hasRequiredSupportOnSideForBlock(location, sideChanged, block)) {
                return false;
            }
        }
        return false;
    }

    private boolean hasRequiredSupportOnSideForBlock(Vector3i location, Side sideChanged, Block block) {
        final BlockMeshPart part = block.getPrimaryAppearance().getPart(BlockPart.fromSide(sideChanged));
        if (part != null) {
            // This block has mesh on this side, therefore it requires a support on that side
            if (!hasSupportFromBlockOnSide(location, sideChanged, Collections.<Vector3i, Block>emptyMap())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSufficientlySupported(Vector3i location, Map<Vector3i, Block> blockOverrides) {
        final SideBlockSupportRequiredComponent component = getComponent(location, blockOverrides);
        if (component != null) {
            final Block block = getBlockWithOverrides(location, blockOverrides);
            for (Side side : Side.values()) {
                if (hasRequiredSupportOnSideForBlock(location, side, block)) {
                    return true;
                }
            }
        }
        return false;
    }

    private EntityRef getEntity(Vector3i location, Map<Vector3i, Block> blockOverrides) {
        final Block overwrittenBlock = blockOverrides.get(location);
        if (overwrittenBlock != null) {
            return overwrittenBlock.getEntity();
        }
        EntityRef blockEntity = blockEntityRegistry.getExistingBlockEntityAt(location);
        if (blockEntity.exists()) {
            return blockEntity;
        } else {
            final Block blockAtPosition = getBlockWithOverrides(location, blockOverrides);
            return blockAtPosition.getEntity();
        }
    }

    private SideBlockSupportRequiredComponent getComponent(Vector3i location, Map<Vector3i, Block> blockOverrides) {
        return getEntity(location, blockOverrides).getComponent(SideBlockSupportRequiredComponent.class);
    }

    private boolean hasSupportFromBlockOnSide(Vector3i blockPosition, Side side, Map<Vector3i, Block> blockOverrides) {
        final Vector3i sideBlockPosition = side.getAdjacentPos(blockPosition);
        if (!worldProvider.isBlockRelevant(sideBlockPosition)) {
            return true;
        }
        return getBlockWithOverrides(sideBlockPosition, blockOverrides).canAttachTo(side.reverse());
    }

    private Block getBlockWithOverrides(Vector3i location, Map<Vector3i, Block> blockOverrides) {
        final Block blockFromOverride = blockOverrides.get(location);
        if (blockFromOverride != null) {
            return blockFromOverride;
        }
        return worldProvider.getBlock(location);
    }
}
