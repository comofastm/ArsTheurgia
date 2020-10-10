package team.comofas.arstheurgia.player;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import nerdhub.cardinal.components.api.util.RespawnCopyStrategy;
import net.minecraft.nbt.CompoundTag;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.player.data.*;

public class PlayerComponents implements EntityComponentInitializer {

    public static final ComponentKey<EvilManager> EVIL;
    public static final ComponentKey<KnowledgeManager> KNOWLEDGE;
    public static final ComponentKey<RitualTimeManager> RITUALTIME;

    static {
        EVIL = ComponentRegistryV3.INSTANCE.getOrCreate(ArsUtils.getIdentifier("evil"), EvilManager.class);
        KNOWLEDGE = ComponentRegistryV3.INSTANCE.getOrCreate(ArsUtils.getIdentifier("knowledge"), KnowledgeManager.class);
        RITUALTIME = ComponentRegistryV3.INSTANCE.getOrCreate(ArsUtils.getIdentifier("ritualtime"), RitualTimeManager.class);
    }

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(EVIL, Evil::new, RespawnCopyStrategy.ALWAYS_COPY);
        registry.registerForPlayers(KNOWLEDGE, Knowledge::new, RespawnCopyStrategy.ALWAYS_COPY);
        registry.registerForPlayers(RITUALTIME, RitualTime::new, RespawnCopyStrategy.ALWAYS_COPY);
    }
}