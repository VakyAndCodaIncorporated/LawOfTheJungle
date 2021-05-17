package coda.lawofthejungle.init;

import coda.lawofthejungle.LawOfTheJungle;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LOTJSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LawOfTheJungle.MOD_ID);

    public static final RegistryObject<SoundEvent> SIAMANG_AMBIENT = SOUNDS.register("siamang_gibbon_ambient", () -> new SoundEvent(new ResourceLocation(LawOfTheJungle.MOD_ID, "siamang_gibbon.ambient")));
    public static final RegistryObject<SoundEvent> SIAMANG_HURT = SOUNDS.register("siamang_gibbon_hurt", () -> new SoundEvent(new ResourceLocation(LawOfTheJungle.MOD_ID, "siamang_gibbon.hurt")));
    public static final RegistryObject<SoundEvent> SIAMANG_DEATH = SOUNDS.register("siamang_gibbon_death", () -> new SoundEvent(new ResourceLocation(LawOfTheJungle.MOD_ID, "siamang_gibbon.death")));
    public static final RegistryObject<SoundEvent> SIAMANG_BOOMING = SOUNDS.register("siamang_gibbon_booming", () -> new SoundEvent(new ResourceLocation(LawOfTheJungle.MOD_ID, "siamang_gibbon.booming")));
}
