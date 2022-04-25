package team.comofas.arstheurgia.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import team.comofas.arstheurgia.registry.ArsBlocks;


// BlockEntity class for blocks that implement a Ritual. Can be extended but should suffice for general block use. (Index usage is assumed.)

public class  RitualBlockEntity extends BlockEntity {
    private int index = 0;
    private ItemStack placedItem;

    public RitualBlockEntity(BlockPos pos, BlockState state) {
        super(ArsBlocks.RITUALBLOCK_ENTITY, pos, state);
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        tag.putInt("index", index);
        tag.put("item", placedItem.writeNbt(new NbtCompound()));
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        index = tag.getInt("index");
        placedItem = ItemStack.fromNbt(tag.getCompound("item"));
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