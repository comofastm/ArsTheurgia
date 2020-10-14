package team.comofas.arstheurgia.player;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import nerdhub.cardinal.components.api.util.RespawnCopyStrategy;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.entity.AnzuEntity;
import team.comofas.arstheurgia.player.data.*;

public class PlayerComponents implements EntityComponentInitializer {

    public static final ComponentKey<EvilManager> EVIL;
    public static final ComponentKey<DryIntManager> DRY;
    public static final ComponentKey<KnowledgeManager> KNOWLEDGE;
    public static final ComponentKey<RitualTimeManager> RITUALTIME;
    public static final ComponentKey<ActiveBlessingManager> ACTIVE_BLESSING;

    static {
        EVIL = ComponentRegistryV3.INSTANCE.getOrCreate(ArsUtils.getIdentifier("evil"), EvilManager.class);
        DRY = ComponentRegistryV3.INSTANCE.getOrCreate(ArsUtils.getIdentifier("dry"), DryIntManager.class);
        KNOWLEDGE = ComponentRegistryV3.INSTANCE.getOrCreate(ArsUtils.getIdentifier("knowledge"), KnowledgeManager.class);
        RITUALTIME = ComponentRegistryV3.INSTANCE.getOrCreate(ArsUtils.getIdentifier("ritualtime"), RitualTimeManager.class);
        ACTIVE_BLESSING = ComponentRegistryV3.INSTANCE.getOrCreate(ArsUtils.getIdentifier("blessing"), ActiveBlessingManager.class);
    }

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(EVIL, Evil::new, RespawnCopyStrategy.ALWAYS_COPY);
        registry.registerForPlayers(KNOWLEDGE, Knowledge::new, RespawnCopyStrategy.ALWAYS_COPY);
        registry.registerForPlayers(RITUALTIME, RitualTime::new, RespawnCopyStrategy.ALWAYS_COPY);
        registry.registerForPlayers(ACTIVE_BLESSING, ActiveBlessing::new, RespawnCopyStrategy.ALWAYS_COPY);
        registry.registerFor(AnzuEntity.class, DRY, DryIntComponent::new);
        registry.registerFor(AnzuEntity.class, RITUALTIME, RitualTime::new);
    }
}
