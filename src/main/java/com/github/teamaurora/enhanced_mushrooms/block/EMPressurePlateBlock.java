package com.github.teamaurora.enhanced_mushrooms.block;

import net.minecraft.block.PressurePlateBlock;

public class EMPressurePlateBlock extends PressurePlateBlock {

    public EMPressurePlateBlock(Settings settings) {
        super(ActivationRule.EVERYTHING, settings);
    }

    public EMPressurePlateBlock(ActivationRule rule, Settings settings) {
        super(rule, settings);
    }

}
