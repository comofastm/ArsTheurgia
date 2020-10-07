package team.comofas.arstheurgia.gui;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import team.comofas.arstheurgia.items.OpenableTablet;
import team.comofas.arstheurgia.registry.ArsItems;
import team.comofas.arstheurgia.ritual.Ritual;
import team.comofas.arstheurgia.ritual.rituals.CreeperSummon;
import team.comofas.arstheurgia.ritual.utils.RitualUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OpenTabletScreen extends Screen {

    public static final Identifier BOOK_TEXTURE = new Identifier("textures/gui/book.png");

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
        int i = (this.width - 192) / 2;
        this.drawTexture(matrices, i, 2, 0, 0, 192, 192);

        float xPos = i + 36;

        if (!this.client.player.inventory.contains(new ItemStack(ArsItems.DICTIONARY))) {
            this.textRenderer.draw(matrices, new LiteralText("sekret"), xPos, 32F, 0);
        }
        else {

            RenderSystem.pushMatrix();
            RenderSystem.multMatrix(matrices.peek().getModel());

            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

            for (Map.Entry<Block, List<BlockPos>> entry: this.ritual.validBlocks.entrySet()) {
                for (BlockPos pos : entry.getValue()) {
                    /*if (entry.getKey() == Blocks.REDSTONE_WIRE) {
                        System.out.println(pos);
                    }*/
                    itemRenderer.renderGuiItemIcon(new ItemStack(entry.getKey()), (int) ((pos.getX()*16)+xPos), (pos.getZ()*16) + 128);

                }
            }

            RenderSystem.popMatrix();

            for (int j = 0; j < lines.size(); j++) {

                this.textRenderer.draw(matrices, lines.get(j), xPos, (float)(32 + j * 9), 0);
            }
        }




    }

}
