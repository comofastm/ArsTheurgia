package team.comofas.arstheurgia.player.data;

import dev.onyxstudios.cca.api.v3.component.Component;
import net.minecraft.entity.Entity;
import team.comofas.arstheurgia.player.PlayerComponents;

public interface DryIntManager extends Component {
    int getDry();
    void setDry(int value);
    void removeDry();
    void addDry();
}

