// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.world.block.structure;

import org.terasology.engine.entitySystem.Component;

/**
 * Component for block entities that are attached to another block and depend on this block allowing to have been
 * attached to. The side it can be attached to is variable (i.e. torch attaches to 4 sides or bottom).
 * <p>
 * If the supporting block is removed or changed to one that does not support attachment, the block (attachment) will be
 * destroyed. The check for which side this block entity is attached to is done via BlockMeshPart.
 */
public class AttachSupportRequiredComponent implements Component {
}
