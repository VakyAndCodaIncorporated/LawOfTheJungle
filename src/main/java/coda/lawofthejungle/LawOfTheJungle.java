package coda.lawofthejungle;

import coda.lawofthejungle.client.ClientEvents;
import coda.lawofthejungle.entities.RingTailedLemurEntity;
import coda.lawofthejungle.entities.SiamangGibbonEntity;
import coda.lawofthejungle.init.LOTJBlocks;
import coda.lawofthejungle.init.LOTJEntities;
import coda.lawofthejungle.init.LOTJItems;
import coda.lawofthejungle.init.LOTJSounds;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LawOfTheJungle.MOD_ID)
public class LawOfTheJungle {
    public static final String MOD_ID = "lawofthejungle";

    public LawOfTheJungle() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::registerClient);
        bus.addListener(this::registerEntityAttributes);

        LOTJItems.ITEMS.register(bus);
        LOTJBlocks.BLOCKS.register(bus);
        LOTJSounds.SOUNDS.register(bus);
        LOTJEntities.ENTITIES.register(bus);
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
         event.put(LOTJEntities.SIAMANG_GIBBON.get(), SiamangGibbonEntity.createAttributes().create());
         event.put(LOTJEntities.RING_TAILED_LEMUR.get(), RingTailedLemurEntity.createAttributes().create());
    }

    private void registerClient(FMLClientSetupEvent event) {
        ClientEvents.init();
    }

}
