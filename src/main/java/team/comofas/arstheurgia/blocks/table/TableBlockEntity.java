package team.comofas.arstheurgia.blocks.table;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import team.comofas.arstheurgia.ArsTheurgia;
import team.comofas.arstheurgia.registry.ArsBlocks;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class TableBlockEntity extends BlockEntity {
    private ItemStack placedItem;

    public TableBlockEntity(BlockPos pos, BlockState state) {
        super(ArsBlocks.TABLE_BLOCK_ENTITY, pos, state);
        placedItem = ItemStack.EMPTY;
        markDirty();
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
}