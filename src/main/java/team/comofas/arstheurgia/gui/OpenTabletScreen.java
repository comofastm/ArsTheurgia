package team.comofas.arstheurgia.gui;

import com.google.common.collect.Lists;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class OpenTabletScreen extends Screen {

    public static final Identifier BOOK_TEXTURE = new Identifier("textures/gui/book.png");

    List<Text> lines = Lists.newArrayList(new LiteralText("aaa"), new LiteralText("aaa"));

    public OpenTabletScreen() {
        super(NarratorManager.EMPTY);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.client.getTextureManager().bindTexture(BOOK_TEXTURE);
        int i = (this.width - 192) / 2;
        this.drawTexture(matrices, i, 2, 0, 0, 192, 192);

        for (int j = 0; j < lines.size(); j++) {

            float xPos = i + 36;
            this.textRenderer.draw(matrices, lines.get(j), xPos, (float)(32 + j * 9), 0);
        }

    }

}
