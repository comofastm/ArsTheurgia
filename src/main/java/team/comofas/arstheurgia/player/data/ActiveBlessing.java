package team.comofas.arstheurgia.player.data;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import team.comofas.arstheurgia.player.PlayerComponents;

public class ActiveBlessing implements ActiveBlessingManager {


    boolean hasActiveBlessing = false;

    private final PlayerEntity player;

    public ActiveBlessing(PlayerEntity player) { this.player = player;}

    @Override
    public boolean hasBlessing() {
        return hasActiveBlessing;
    }

    @Override
    public void setBlessing(boolean hasBlessing) {
        this.hasActiveBlessing = hasBlessing;
        sync();
    }

    private void sync() {
        PlayerComponents.ACTIVE_BLESSING.sync(player);
    }

    @Override
    public void readFromNbt(CompoundTag tag) {
        hasActiveBlessing = tag.getBoolean("blessing");

        sync();
    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        tag.putBoolean("blessing", hasActiveBlessing);
    }

}
