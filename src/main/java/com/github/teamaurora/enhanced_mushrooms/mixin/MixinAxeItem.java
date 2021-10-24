package com.github.teamaurora.enhanced_mushrooms.mixin;

import com.github.teamaurora.enhanced_mushrooms.util.WoodBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.Map;

@Mixin(AxeItem.class)
public class MixinAxeItem {
    @Shadow
    @Final
    @Mutable
    protected static Map<Block, Block> STRIPPED_BLOCKS;

    static {
        STRIPPED_BLOCKS = new HashMap<>(STRIPPED_BLOCKS);
        STRIPPED_BLOCKS.putAll(WoodBlocks.stripMap);
    }
}
