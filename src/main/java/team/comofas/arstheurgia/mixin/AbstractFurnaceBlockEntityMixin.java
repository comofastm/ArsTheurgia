package team.comofas.arstheurgia.mixin;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import team.comofas.arstheurgia.registry.ArsItems;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {


    /*@Shadow protected DefaultedList<ItemStack> inventory;

    @ModifyVariable(method = "craftRecipe", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/recipe/Recipe;getOutput()Lnet/minecraft/item/ItemStack;"), ordinal = 1)
    private ItemStack modifyOutput(ItemStack itemStack2) {

        if (itemStack2.getItem() == ArsItems.COOKED_CLAY_TABLET) {
            itemStack2.setTag(this.inventory.get(0).getTag());
        }

        return itemStack2;

    }*/

}
