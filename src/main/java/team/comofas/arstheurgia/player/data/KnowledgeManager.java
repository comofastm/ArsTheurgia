package team.comofas.arstheurgia.player.data;

import dev.onyxstudios.cca.api.v3.component.Component;

public interface KnowledgeManager extends Component {

    boolean hasKnowledge(String key);

    void setKnowledge(String key, boolean var);

    
}
