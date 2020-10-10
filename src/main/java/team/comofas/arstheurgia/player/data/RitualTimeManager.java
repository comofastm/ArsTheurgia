package team.comofas.arstheurgia.player.data;

import dev.onyxstudios.cca.api.v3.component.AutoSyncedComponent;

public interface RitualTimeManager extends AutoSyncedComponent {

    int getInt(String key);

    void setInt(String key);

    
}
