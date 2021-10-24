package com.github.teamaurora.enhanced_mushrooms;

import com.github.teamaurora.enhanced_mushrooms.init.EMBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class EnhancedMushroomsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
                EMBlocks.BROWN_MUSHROOM.door,
                EMBlocks.BROWN_MUSHROOM.trapdoor
        );
    }
}