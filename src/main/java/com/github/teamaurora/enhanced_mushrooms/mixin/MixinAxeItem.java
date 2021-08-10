package com.github.teamaurora.enhanced_mushrooms.mixin;

import com.github.teamaurora.enhanced_mushrooms.init.EMBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.Map;

@Mixin(AxeItem.class)
abstract class MixinAxeItem {
    @Shadow
    @Final
    @Mutable
    protected static Map<Block, Block> STRIPPED_BLOCKS;

    static {
        STRIPPED_BLOCKS = new HashMap<>(STRIPPED_BLOCKS);
        STRIPPED_BLOCKS.put(EMBlocks.BROWN_MUSHROOM.log, EMBlocks.BROWN_MUSHROOM.strippedLog);
        STRIPPED_BLOCKS.put(EMBlocks.BROWN_MUSHROOM.wood, EMBlocks.BROWN_MUSHROOM.strippedWood);
        STRIPPED_BLOCKS.put(EMBlocks.RED_MUSHROOM.log, EMBlocks.RED_MUSHROOM.strippedLog);
        STRIPPED_BLOCKS.put(EMBlocks.RED_MUSHROOM.wood, EMBlocks.RED_MUSHROOM.strippedWood);
    }
}
