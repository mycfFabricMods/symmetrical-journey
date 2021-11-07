package org.mycf.symmetrical.journey.blocks.screenhandlers.fletchingtable

import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text
import net.minecraft.util.Identifier

class FletchingScreen(screenHandler: FletchingBlockScreenHandler?, playerInventory: PlayerInventory?, title: Text?) :
    HandledScreen<FletchingBlockScreenHandler>(
        screenHandler, playerInventory, title) {

    companion object {
        private val TEXTURE: Identifier = Identifier("minecraft", "textures/gui/container/anvil.png")
    }

    @Override
    override fun drawBackground(matrices: MatrixStack?, delta: Float, mouseX: Int, mouseY: Int) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F)
        client?.textureManager?.bindTexture(TEXTURE)
        val x = (width - backgroundWidth) / 2;
        val y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    override fun render(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    override fun init() {
        super.init()
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2
    }
}