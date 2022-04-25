package team.comofas.arstheurgia.player.data;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import team.comofas.arstheurgia.player.PlayerComponents;

public class Knowledge implements KnowledgeManager {

    NbtCompound knowledge = new NbtCompound();

    private final PlayerEntity player;

    public Knowledge(PlayerEntity player) { this.player = player;}

    @Override
    public boolean hasKnowledge(String key) {
        return knowledge.getBoolean(key);
    }

    @Override
    public void setKnowledge(String key, boolean var) {
        this.knowledge.putBoolean(key, var);
        sync();
    }

    private void sync() {
        PlayerComponents.KNOWLEDGE.sync(player);
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        knowledge = tag.getCompound("knowledge");
        sync();
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.put("knowledge", knowledge);
    }

}
