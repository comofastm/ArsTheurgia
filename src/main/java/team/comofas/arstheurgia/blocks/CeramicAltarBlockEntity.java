package team.comofas.arstheurgia.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import team.comofas.arstheurgia.registry.ArsBlocks;

public class CeramicAltarBlockEntity extends BlockEntity {
    private int index = 0;
    private ItemStack placedItem;

    public CeramicAltarBlockEntity() {
        super(ArsBlocks.CERAMIC_ALTAR_ENTITY);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putInt("index", index);
        tag.put("item", placedItem.toTag(new CompoundTag()));

        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        index = tag.getInt("index");
        placedItem = ItemStack.fromTag(tag.getCompound("item"));
    }

    public ItemStack getPlacedItem() {
        return placedItem;
    }

    public void setPlacedItem(ItemStack placedItem) {
        this.placedItem = placedItem;
        markDirty();
    }

    public int getIndex() {
        return index;
    }

    public void addIndex() {
        index++;
        markDirty();
    }

    public void resetIndex() {
        index = 0;
        markDirty();
    }
}
