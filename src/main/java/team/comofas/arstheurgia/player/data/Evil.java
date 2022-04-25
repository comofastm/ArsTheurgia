package team.comofas.arstheurgia.player.data;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import team.comofas.arstheurgia.player.PlayerComponents;

public class Evil implements EvilManager {

    private int evil = 0;

    private final PlayerEntity player;

    public Evil(PlayerEntity player) { this.player = player;}

    @Override
    public int getEvil() {
        return evil;
    }

    @Override
    public void setEvil(int evil) {
        this.evil = evil;
        sync();
    }

    private void sync() {
        PlayerComponents.EVIL.sync(player);
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        evil = tag.getInt("evil");

        sync();
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("evil", evil);
    }

}
