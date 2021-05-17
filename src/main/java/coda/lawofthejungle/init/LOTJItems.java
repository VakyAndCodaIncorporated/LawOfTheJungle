package coda.lawofthejungle.init;

import coda.lawofthejungle.LawOfTheJungle;
import coda.lawofthejungle.items.LOTJSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LOTJItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LawOfTheJungle.MOD_ID);

    public static final RegistryObject<Item> SIAMANG_GIBBON_SPAWN_EGG = ITEMS.register("siamang_gibbon_spawn_egg", () -> new LOTJSpawnEggItem(LOTJEntities.SIAMANG_GIBBON, 0x383635, 0x1c1818, new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> RING_TAILED_LEMUR_SPAWN_EGG = ITEMS.register("ring_tailed_lemur_spawn_egg", () -> new LOTJSpawnEggItem(LOTJEntities.RING_TAILED_LEMUR, 0x6b6661, 0xeeebe5, new Item.Properties().group(ItemGroup.MATERIALS)));
}
