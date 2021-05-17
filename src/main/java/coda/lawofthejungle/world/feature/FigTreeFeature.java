package coda.lawofthejungle.world.feature;

import coda.lawofthejungle.init.LOTJBlocks;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class FigTreeFeature extends Feature<NoFeatureConfig> {
    private final BlockState trunk = LOTJBlocks.FIG_STALK.get().getDefaultState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y);
    private final BlockState leaves = LOTJBlocks.FIG_LEAVES.get().getDefaultState();

    public FigTreeFeature() {
        super(NoFeatureConfig.field_236558_a_);
    }

    @Override
    public boolean generate(ISeedReader iSeedReader, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, NoFeatureConfig noFeatureConfig) {
        if (iSeedReader.getBlockState(blockPos.down()).getBlock() == Blocks.GRASS_BLOCK && iSeedReader.getBlockState(blockPos.down().south()).getBlock() == Blocks.DIRT) {
            for (int i = -1; i < 6; i++) {
                setBlockState(iSeedReader, blockPos.up(i), trunk);
                setBlockState(iSeedReader, blockPos.add(1, i, 0), trunk);
                setBlockState(iSeedReader, blockPos.add(0, i, 1), trunk);
                setBlockState(iSeedReader, blockPos.add(1, i, 1), trunk);
                if (i > 0 && i <= 4) {
                    addLeavesSide(iSeedReader, blockPos.up(i), direction -> trunk);
                }
            }

            addLeaves(iSeedReader, blockPos.add(-2, 4, 0));
            addLeaves(iSeedReader, blockPos.add(1, 4, -2));
            addLeaves(iSeedReader, blockPos.add(3, 4, 1));
            addLeaves(iSeedReader, blockPos.add(0, 4, 3));

            addLeavesSide(iSeedReader, blockPos.up(6), direction -> leaves.with(CoralWallFanBlock.FACING, direction));

            return true;
        }
        return false;
    }

    public void addLeavesSide(IWorldWriter world, BlockPos pos, Function<Direction, BlockState> directionSetter) {
        setBlockState(world, pos.add(2, -1, 0), directionSetter.apply(Direction.EAST));
        setBlockState(world, pos.add(2, -1, 1), directionSetter.apply(Direction.EAST));
        setBlockState(world, pos.add(-1, -1, 0), directionSetter.apply(Direction.WEST));
        setBlockState(world, pos.add(-1, -1, 1), directionSetter.apply(Direction.WEST));
        setBlockState(world, pos.add(0, -1, 2), directionSetter.apply(Direction.SOUTH));
        setBlockState(world, pos.add(1, -1, 2), directionSetter.apply(Direction.SOUTH));
        setBlockState(world, pos.add(0, -1, -1), directionSetter.apply(Direction.NORTH));
        setBlockState(world, pos.add(1, -1, -1), directionSetter.apply(Direction.NORTH));
    }

    public void addLeaves(IWorldWriter world, BlockPos pos) {
        setBlockState(world, pos, trunk);

        for (int i = 0; i <= 4; i++) {
            Direction direction = Direction.byHorizontalIndex(i);
            setBlockState(world, pos.offset(direction), leaves.with(LeavesBlock.DISTANCE, 1));
        }
    }
}
