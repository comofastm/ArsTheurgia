package team.comofas.arstheurgia.items;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LecternBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.comofas.arstheurgia.ArsTheurgia;
import team.comofas.arstheurgia.gui.GuiUtils;
import team.comofas.arstheurgia.player.PlayerComponents;

import java.awt.print.Book;
import java.util.List;

public class OpenableTablet extends Item {

    public String ritualName;

    public OpenableTablet(Settings settings, String ritualName) {
        super(settings);
        this.ritualName = ritualName;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (world.isClient) {
            GuiUtils.openTabletScreen(itemStack);
        } else {
            if (itemStack.getItem().getName().getString().startsWith("item.arstheurgia.cooked_clay_tablet_")) {

                PlayerComponents.KNOWLEDGE.get(user).setKnowledge(this.ritualName, true);

            }
        }

        return TypedActionResult.method_29237(itemStack, world.isClient());

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.arstheurgia.cooked_clay_tablet_" + this.ritualName + ".tooltip"));
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        return ActionResult.FAIL;
    }

}

