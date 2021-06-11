package com.github.teamaurora.enhanced_mushrooms;

import com.github.teamaurora.enhanced_mushrooms.block.EMBoatEntity;
import com.github.teamaurora.enhanced_mushrooms.init.EMBlocks;
import com.github.teamaurora.enhanced_mushrooms.init.EMBoats;
import com.github.teamaurora.enhanced_mushrooms.util.BoatSpawnNetworkHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.entity.EntityType;

public class EnhancedMushroomsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BoatSpawnNetworkHandler.register();

        addBoats(
                EMBoats.RED_MUSHROOM_BOAT,
                EMBoats.BROWN_MUSHROOM_BOAT
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
                EMBlocks.BROWN_MUSHROOM.door,
                EMBlocks.BROWN_MUSHROOM.trapdoor
        );
    }

    private void addBoats(EntityType<EMBoatEntity> ... boats) {
        for (EntityType<EMBoatEntity> boat : boats) {
            addBoat(boat);
        }
    }

    private void addBoat(EntityType<EMBoatEntity> boat) {
        EntityRendererRegistry.INSTANCE.register(boat, BoatEntityRenderer::new);
    }
}