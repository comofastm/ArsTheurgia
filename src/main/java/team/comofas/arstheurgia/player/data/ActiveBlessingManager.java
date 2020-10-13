package team.comofas.arstheurgia.player.data;

import dev.onyxstudios.cca.api.v3.component.AutoSyncedComponent;

public interface ActiveBlessingManager extends AutoSyncedComponent {

    boolean hasBlessing();

    void setBlessing(boolean hasBlessing);

}
