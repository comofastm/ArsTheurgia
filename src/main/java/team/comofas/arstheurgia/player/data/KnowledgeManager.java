package team.comofas.arstheurgia.player.data;

import dev.onyxstudios.cca.api.v3.component.AutoSyncedComponent;

public interface KnowledgeManager extends AutoSyncedComponent {

    boolean hasKnowledge(String key);

    void setKnowledge(String key, boolean var);

    
}
