package team.comofas.arstheurgia.player.data;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import team.comofas.arstheurgia.player.PlayerComponents;

public class RitualTime implements RitualTimeManager {

    CompoundTag ritualtime = new CompoundTag();

    private final PlayerEntity player;


    public RitualTime(PlayerEntity player) { this.player = player;}

    @Override
    public int getInt(String key) {
        return ritualtime.getInt(key);
    }

    @Override
    public void setInt(String key) {
        this.ritualtime.putInt(key, (int) player.getEntityWorld().getTime());
        sync();
    }

    private void sync() {
        PlayerComponents.RITUALTIME.sync(player);
    }

    @Override
    public void readFromNbt(CompoundTag tag) {
        ritualtime = tag.getCompound("ritual_time");
        sync();
    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        tag.put("ritual_time", ritualtime);
    }

}
