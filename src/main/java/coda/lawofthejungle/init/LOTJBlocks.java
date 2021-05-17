package coda.lawofthejungle.init;

import coda.lawofthejungle.LawOfTheJungle;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LOTJBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LawOfTheJungle.MOD_ID);

    public static final RegistryObject<Block> FIG_STALK = BLOCKS.register("fig_stalk", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.LIGHT_GRAY).hardnessAndResistance(1.5F).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> FIG_LEAVES = BLOCKS.register("fig_leaves", () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES, MaterialColor.FOLIAGE).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
}
