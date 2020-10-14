package team.comofas.arstheurgia.gui;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.items.OpenableTablet;
import team.comofas.arstheurgia.registry.ArsItems;
import team.comofas.arstheurgia.ritual.Ritual;
import team.comofas.arstheurgia.ritual.rituals.CreeperSummon;
import team.comofas.arstheurgia.ritual.utils.RitualUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OpenTabletScreen extends Screen {

    public static final Identifier BOOK_TEXTURE = ArsUtils.getIdentifier("textures/gui/tablet_big.png");

    List<Text> lines = new ArrayList<>();

    private Ritual ritual;

    public OpenTabletScreen(ItemStack heldItem) {
        super(NarratorManager.EMPTY);

        String ritualName = ((OpenableTablet)heldItem.getItem()).ritualName;

        this.ritual = Ritual.ritualsByName.get(ritualName);


        for (String s : I18n.translate(String.format("ritual.%s.tablet.text", ritualName)).split("\n")) {
            lines.add(new LiteralText(s));
        }

    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.client.getTextureManager().bindTexture(BOOK_TEXTURE);
        int i = (this.width - (438)) / 2;
        drawTexture(matrices, i, 2, 0, 0, 438, 270, 438, 270);

        if (!this.client.player.inventory.contains(new ItemStack(ArsItems.DICTIONARY))) {
            this.textRenderer.draw(matrices, new LiteralText("sekret"), (float) i, 32F, 0);
        }
        else {

            RenderSystem.pushMatrix();
            RenderSystem.multMatrix(matrices.peek().getModel());

            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

            for (Map.Entry<Block, List<BlockPos>> entry: this.ritual.validBlocks.entrySet()) {
                for (BlockPos pos : entry.getValue()) {
                    if (pos.getY() == 0)
                        itemRenderer.renderGuiItemIcon(new ItemStack(entry.getKey()), (int) ((pos.getX()*18) + (float) i + 320), (pos.getZ()*18)+150);

                }
            }

            RenderSystem.popMatrix();

            this.textRenderer.draw(matrices, new TranslatableText("ritual.text.configuration"), (float) i + 16 + 204, (float)(32 + 9), 0);


            for (int j = 0; j < lines.size(); j++) {

                this.textRenderer.draw(matrices, lines.get(j), (float) i + 20, (float)(16 + j * 9), 0);
            }
        }




    }

}
