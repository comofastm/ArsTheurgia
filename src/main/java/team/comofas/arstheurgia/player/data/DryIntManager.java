package team.comofas.arstheurgia.player.data;

import dev.onyxstudios.cca.api.v3.component.AutoSyncedComponent;
import nerdhub.cardinal.components.api.component.Component;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import team.comofas.arstheurgia.player.PlayerComponents;

public interface DryIntManager extends AutoSyncedComponent {
    int getDry();
    void setDry(int value);
    void removeDry();
    void addDry();
}

