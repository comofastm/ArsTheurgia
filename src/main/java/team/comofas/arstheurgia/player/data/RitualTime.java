package team.comofas.arstheurgia.player.data;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import team.comofas.arstheurgia.player.PlayerComponents;

public class RitualTime implements RitualTimeManager {

    CompoundTag ritualtime = new CompoundTag();

    private final Entity player;


    public RitualTime(Entity player) { this.player = player;}

    @Override
    public int getInt(String key) {
        return ritualtime.getInt(key);
    }

    @Override
    public void setIntTime(String key) {
        this.ritualtime.putInt(key, (int) player.getEntityWorld().getTime());
        sync();
    }

    @Override
    public void setInt(String key, int value) {
        this.ritualtime.putInt(key, value);
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
