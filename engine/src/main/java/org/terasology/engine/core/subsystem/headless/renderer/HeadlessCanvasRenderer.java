// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.core.subsystem.headless.renderer;

import org.joml.Rectanglei;
import org.joml.Vector2i;
import org.terasology.engine.rendering.assets.material.Material;
import org.terasology.engine.rendering.assets.mesh.Mesh;
import org.terasology.engine.rendering.nui.internal.TerasologyCanvasRenderer;
import org.terasology.engine.rendering.opengl.FrameBufferObject;
import org.terasology.gestalt.assets.ResourceUrn;
import org.terasology.math.geom.BaseVector2i;
import org.terasology.math.geom.Quat4f;
import org.terasology.math.geom.Rect2i;
import org.terasology.math.geom.Vector3f;
import org.terasology.nui.Border;
import org.terasology.nui.Colorc;
import org.terasology.nui.HorizontalAlign;
import org.terasology.nui.ScaleMode;
import org.terasology.nui.UITextureRegion;
import org.terasology.nui.VerticalAlign;
import org.terasology.nui.asset.font.Font;

public class HeadlessCanvasRenderer implements TerasologyCanvasRenderer {

    @Override
    public void preRender() {
        // Do nothing
    }

    @Override
    public void postRender() {
        // Do nothing
    }

    @Override
    public void drawMesh(Mesh mesh, Material material, Rect2i drawRegion, Rect2i cropRegion, Quat4f rotation,
                         Vector3f offset, float scale, float alpha) {
        // Do nothing
    }

    @Override
    public Vector2i getTargetSize() {
        return new Vector2i();
    }

    @Override
    public void drawMaterialAt(Material material, Rect2i drawRegion) {
        // Do nothing
    }

    @Override
    public void crop(Rectanglei cropRegion) {
        // Do nothing
    }

    @Override
    public void drawLine(int sx, int sy, int ex, int ey, Colorc color) {
        // do nothing
    }

    @Override
    public void drawTexture(UITextureRegion texture, Colorc color, ScaleMode mode, Rectanglei absoluteRegion, float ux,
                            float uy, float uw, float uh, float alpha) {
        // do nothing
    }

    @Override
    public void drawText(String text, Font font, HorizontalAlign hAlign, VerticalAlign vAlign,
                         Rectanglei absoluteRegion, Colorc color,
                         Colorc shadowColor, float alpha, boolean underlined) {
        // do nothing
    }

    @Override
    public FrameBufferObject getFBO(ResourceUrn uri, BaseVector2i region) {
        return null;
    }

    @Override
    public void drawTextureBordered(UITextureRegion texture, Rectanglei absoluteRegion, Border border, boolean tile,
                                    float ux, float uy, float uw, float uh, float alpha) {
        // Do nothing
    }

    @Override
    public void setUiScale(float uiScale) {
        // Do nothing
    }
}
