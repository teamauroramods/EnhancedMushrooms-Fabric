package com.github.teamaurora.enhanced_mushrooms.mixin;

import com.github.teamaurora.enhanced_mushrooms.init.EMFeatures;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(MushroomPlantBlock.class)
public class MushroomPlantBlockMixin extends PlantBlock implements Fertilizable {
    @Shadow
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Shadow
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return (double)random.nextFloat() < 0.4D;
    }

    protected MushroomPlantBlockMixin(Settings settings) {
        super(settings);
    }

    public boolean trySpawningEnhancedBigMushroom(ServerWorld serverWorld, BlockPos pos, BlockState state, Random random) {
        serverWorld.removeBlock(pos, false);
        ConfiguredFeature configuredFeature3;
        if (this == Blocks.BROWN_MUSHROOM) {
            configuredFeature3 = EMFeatures.HUGE_BROWN_MUSHROOM;
        } else {
            if (this != Blocks.RED_MUSHROOM) {
                serverWorld.setBlockState(pos, state, 3);
                return false;
            }

            configuredFeature3 = EMFeatures.HUGE_RED_MUSHROOM;
        }

        if (configuredFeature3.generate(serverWorld, serverWorld.getChunkManager().getChunkGenerator(), random, pos)) {
            return true;
        } else {
            serverWorld.setBlockState(pos, state, 3);
            return false;
        }
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        this.trySpawningEnhancedBigMushroom(world, pos, state, random);
    }
}