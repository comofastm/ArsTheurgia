package team.comofas.arstheurgia.player.data;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import team.comofas.arstheurgia.player.PlayerComponents;

public class DryIntComponent implements DryIntManager {

    private final Entity entity;

    private int value = 8;

    public DryIntComponent(Entity entity) { this.entity = entity; }

    @Override public int getDry() { return this.value; }

    private void sync() {
        PlayerComponents.DRY.sync(entity);
    }

    @Override
    public void setDry(int value) {
        this.value = value;
        sync();
    }

    @Override
    public void removeDry() {
        if (this.getDry() > 0) {
            this.value = value-1;
            sync();
        }
    }

    @Override
    public void addDry() {
        if (this.getDry() < 8) {
            this.value = value+1;
            sync();
        }
    }

    @Override
    public void readFromNbt(CompoundTag tag) {
        value = tag.getInt("dry");
        sync();
    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        tag.putInt("dry", value);
    }
}
