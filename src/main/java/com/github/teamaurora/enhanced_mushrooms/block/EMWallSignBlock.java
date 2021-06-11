package com.github.teamaurora.enhanced_mushrooms.block;

import com.github.teamaurora.enhanced_mushrooms.util.EMSign;
import net.minecraft.block.WallSignBlock;
import net.minecraft.util.SignType;

public class EMWallSignBlock extends WallSignBlock implements EMSign {
    public EMWallSignBlock(Settings settings, SignType signType) {
        super(settings, signType);
    }
}