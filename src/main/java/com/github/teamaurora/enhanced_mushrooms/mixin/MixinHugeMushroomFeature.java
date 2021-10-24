package com.github.teamaurora.enhanced_mushrooms.mixin;

import com.github.teamaurora.enhanced_mushrooms.init.EMBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.HugeBrownMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.HugeRedMushroomFeature;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(HugeMushroomFeature.class)
public class MixinHugeMushroomFeature {

    @Redirect(method = "generateStem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/gen/stateprovider/BlockStateProvider;getBlockState(Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;"))
    public BlockState useEM(BlockStateProvider instance, Random random, BlockPos blockPos) {
        if (this.getClass().isAssignableFrom(HugeRedMushroomFeature.class)) {
            return EMBlocks.RED_MUSHROOM.log.getDefaultState();
        }
        if (this.getClass().isAssignableFrom(HugeBrownMushroomFeature.class)) {
            return EMBlocks.BROWN_MUSHROOM.log.getDefaultState();
        }
        return instance.getBlockState(random, blockPos).getBlock().getDefaultState();
    }

}
