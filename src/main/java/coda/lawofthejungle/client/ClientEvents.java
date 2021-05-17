package coda.lawofthejungle.client;

import coda.lawofthejungle.LawOfTheJungle;
import coda.lawofthejungle.client.renderer.RingTailedLemurRenderer;
import coda.lawofthejungle.client.renderer.SiamangGibbonRenderer;
import coda.lawofthejungle.init.LOTJBlocks;
import coda.lawofthejungle.init.LOTJEntities;
import coda.lawofthejungle.items.LOTJSpawnEggItem;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.MOD, modid = LawOfTheJungle.MOD_ID)
public class ClientEvents {

    public static void init() {
         RenderingRegistry.registerEntityRenderingHandler(LOTJEntities.SIAMANG_GIBBON.get(), SiamangGibbonRenderer::new);
         RenderingRegistry.registerEntityRenderingHandler(LOTJEntities.RING_TAILED_LEMUR.get(), RingTailedLemurRenderer::new);
    }

    @SubscribeEvent
    public static void itemColors(ColorHandlerEvent.Item event) {
         ItemColors handler = event.getItemColors();
         IItemColor eggColor = (stack, tintIndex) -> ((LOTJSpawnEggItem) stack.getItem()).getColor(tintIndex);
         for (LOTJSpawnEggItem e : LOTJSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
    }


    @SubscribeEvent
    public static void blockColors(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((state, reader, pos, tintIndex) -> reader != null && pos != null ? BiomeColors.getWaterColor(reader, pos) : -1, LOTJBlocks.FIG_LEAVES.get());
    }
}
