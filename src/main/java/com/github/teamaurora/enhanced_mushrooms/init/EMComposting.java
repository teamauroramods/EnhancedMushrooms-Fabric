package com.github.teamaurora.enhanced_mushrooms.init;

import net.minecraft.block.ComposterBlock;

public class EMComposting {
    public static void init() {
        ComposterBlock.registerCompostableItem(0.3F, EMItems.ROASTED_MUSHROOMS);
    }
}