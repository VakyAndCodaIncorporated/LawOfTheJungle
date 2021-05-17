package coda.lawofthejungle.init;

import coda.lawofthejungle.LawOfTheJungle;
import coda.lawofthejungle.entities.RingTailedLemurEntity;
import coda.lawofthejungle.entities.SiamangGibbonEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LOTJEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, LawOfTheJungle.MOD_ID);

    public static final RegistryObject<EntityType<SiamangGibbonEntity>> SIAMANG_GIBBON = create("siamang_gibbon", EntityType.Builder.create(SiamangGibbonEntity::new, EntityClassification.CREATURE).size(0.45F, 1.3F));
    public static final RegistryObject<EntityType<RingTailedLemurEntity>> RING_TAILED_LEMUR = create("ring_tailed_lemur", EntityType.Builder.create(RingTailedLemurEntity::new, EntityClassification.CREATURE).size(0.55F, 0.65F));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(LawOfTheJungle.MOD_ID + "." + name));
    }
}