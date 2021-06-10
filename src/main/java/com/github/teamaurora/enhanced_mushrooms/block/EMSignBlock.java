package com.github.teamaurora.enhanced_mushrooms.block;

import com.github.teamaurora.enhanced_mushrooms.util.EMSign;
import net.minecraft.block.SignBlock;
import net.minecraft.util.SignType;

public class EMSignBlock extends SignBlock implements EMSign {
    public EMSignBlock(Settings settings, SignType signType) {
        super(settings, signType);
    }
}