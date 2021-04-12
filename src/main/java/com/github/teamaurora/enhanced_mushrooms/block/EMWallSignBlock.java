package com.github.teamaurora.enhanced_mushrooms.block;

import com.github.teamaurora.enhanced_mushrooms.util.EMSign;
import net.minecraft.block.WallSignBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;

public class EMWallSignBlock extends WallSignBlock implements EMSign {

    private final Identifier texture;

    public EMWallSignBlock(Identifier texture, Settings settings) {
        super(settings, SignType.OAK); //TODO: take a look at this again
        this.texture = texture;
    }

    @Override
    public Identifier getTexture() {
        return texture;
    }

}