package team.comofas.arstheurgia.blocks.table;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;
import team.comofas.arstheurgia.ArsTheurgia;
import team.comofas.arstheurgia.registry.ArsBlocks;

import java.util.stream.Stream;

public class TableBlockEntity extends BlockEntity implements BlockEntityClientSerializable {
    private ItemStack placedItem;

    public TableBlockEntity() {
        super(ArsBlocks.TABLE_BLOCK_ENTITY);
        markDirty();
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
        sync();
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