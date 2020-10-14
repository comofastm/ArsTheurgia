package team.comofas.arstheurgia.blocks.table;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import team.comofas.arstheurgia.registry.ArsBlocks;

public class TableBlockEntity extends BlockEntity {
    private int index = 0;
    private ItemStack placedItem;

    public TableBlockEntity() {
        super(ArsBlocks.TABLE_BLOCK_ENTITY);
    }

    // TODO put item in tag to save

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