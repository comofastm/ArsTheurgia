package team.comofas.arstheurgia.player.data;


import dev.onyxstudios.cca.api.v3.component.Component;

public interface RitualTimeManager extends Component {

    int getInt(String key);

    void setIntTime(String key);

    void setInt(String key, int value);
    
}
