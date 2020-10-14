package team.comofas.arstheurgia.blocks.ceramicaltar;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import team.comofas.arstheurgia.registry.ArsBlocks;

public class CeramicAltarBlockEntity extends BlockEntity implements BlockEntityClientSerializable {
    private int index = 0;
    private ItemStack placedItem;

    public CeramicAltarBlockEntity() {
        super(ArsBlocks.CERAMIC_ALTAR_ENTITY);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        if (placedItem == null) {
            tag.put("item", ItemStack.EMPTY.toTag(new CompoundTag()));
        } else {
            tag.put("item", placedItem.toTag(new CompoundTag()));
        }


        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        if (tag.getCompound("item").isEmpty()) {
            return;
        }

        setPlacedItem(ItemStack.fromTag(tag.getCompound("item")));

    }

    public ItemStack getPlacedItem() {
        return placedItem;
    }

    public void setPlacedItem(ItemStack placedItem) {
        this.placedItem = placedItem;
        markDirty();
    }


    @Override
    public void fromClientTag(CompoundTag compoundTag) {
        fromTag(this.world.getBlockState(this.pos), compoundTag);
    }

    @Override
    public CompoundTag toClientTag(CompoundTag compoundTag) {
        return toTag(compoundTag);
    }
}
