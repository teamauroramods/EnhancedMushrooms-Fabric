package com.github.teamaurora.enhanced_mushrooms.block;

import com.github.teamaurora.enhanced_mushrooms.util.EMSign;
import net.minecraft.block.SignBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;

public class EMSignBlock extends SignBlock implements EMSign {

    private final Identifier texture;

    public EMSignBlock(Identifier texture, Settings settings) {
        super(settings, SignType.OAK);
        this.texture = texture;
    }

    @Override
    public Identifier getTexture() {
        return texture;
    }

}
