package team.comofas.arstheurgia.mixin;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.comofas.arstheurgia.registry.ArsItems;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {


    @Shadow protected DefaultedList<ItemStack> inventory;

    @ModifyVariable(method = "craftRecipe", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/recipe/Recipe;getOutput()Lnet/minecraft/item/ItemStack;"), ordinal = 1)
    private ItemStack modifyOutput(ItemStack itemStack2) {

        if (itemStack2.getItem() == ArsItems.COOKED_CLAY_TABLET) {
            itemStack2.setTag(this.inventory.get(0).getTag());
        }

        return itemStack2;

    }

}
