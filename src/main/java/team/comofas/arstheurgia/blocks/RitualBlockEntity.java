package team.comofas.arstheurgia.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import team.comofas.arstheurgia.registry.ArsBlocks;


// BlockEntity class for blocks that implement a Ritual. Can be extended but should suffice for general block use. (Index usage is assumed.)

public class  RitualBlockEntity extends BlockEntity {
    private int index = 0;
    private ItemStack placedItem;

    public RitualBlockEntity() {
        super(ArsBlocks.RITUALBLOCK_ENTITY);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putInt("index", index);
        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        index = tag.getInt("index");
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