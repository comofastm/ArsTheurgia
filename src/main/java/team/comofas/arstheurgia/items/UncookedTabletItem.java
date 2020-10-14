package team.comofas.arstheurgia.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UncookedTabletItem extends Item {

    private String ritualName;

    public UncookedTabletItem(Settings settings, String ritualName) {
        super(settings);
        this.ritualName = ritualName;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.arstheurgia.written_clay_tablet_" + this.ritualName + ".tooltip"));
    }

}
