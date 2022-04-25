package team.comofas.arstheurgia.blocks.ceramicaltar;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import team.comofas.arstheurgia.registry.ArsBlocks;

import javax.annotation.Nullable;

public class CeramicAltarBlockEntity extends BlockEntity {

    private ItemStack placedItem;

    public CeramicAltarBlockEntity(BlockPos pos, BlockState state) {

        super(ArsBlocks.CERAMIC_ALTAR_ENTITY, pos, state);
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        if (placedItem == null) {
            tag.put("item", ItemStack.EMPTY.writeNbt(new NbtCompound()));
        } else {
            tag.put("item", placedItem.writeNbt(new NbtCompound()));
        }
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        if (tag.getCompound("item").isEmpty()) {
            return;
        }

        setPlacedItem(ItemStack.fromNbt(tag.getCompound("item")));

    }

    public ItemStack getPlacedItem() {
        return placedItem;
    }

    public void setPlacedItem(ItemStack placedItem) {
        this.placedItem = placedItem;
        markDirty();
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

/*
    @Override
    public void fromClientTag(NbtCompound compoundTag) {
        readNbt(this.world.getBlockState(this.pos), compoundTag);
    }

    @Override
    public NbtCompound toClientTag(NbtCompound compoundTag) {
        return writeNbt(compoundTag);
    }

 */
}
