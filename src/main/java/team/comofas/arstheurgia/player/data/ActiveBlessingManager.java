package team.comofas.arstheurgia.player.data;


import dev.onyxstudios.cca.api.v3.component.Component;

public interface ActiveBlessingManager extends Component {

    boolean hasBlessing();

    void setBlessing(boolean hasBlessing);

}
