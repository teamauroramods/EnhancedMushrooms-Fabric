package com.github.teamaurora.enhanced_mushrooms;

import com.github.teamaurora.enhanced_mushrooms.block.EMBoatEntity;
import com.github.teamaurora.enhanced_mushrooms.block.EMSignBlock;
import com.github.teamaurora.enhanced_mushrooms.init.EMBlocks;
import com.github.teamaurora.enhanced_mushrooms.init.EMBoats;
import com.github.teamaurora.enhanced_mushrooms.util.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

public class EnhancedMushroomsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        addBoatRenderer(EMBoats.RED_MUSHROOM_BOAT);
        addBoatRenderer(EMBoats.BROWN_MUSHROOM_BOAT);

        addSigns(
                EMBlocks.RED_MUSHROOM.sign,
                EMBlocks.BROWN_MUSHROOM.sign
        );

        //BlockRenderLayerMap.INSTANCE.putBlock(EMBlocks.RED_MUSHROOM.ladder, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(EMBlocks.BROWN_MUSHROOM.door, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(EMBlocks.BROWN_MUSHROOM.trapdoor, RenderLayer.getCutoutMipped());
        //BlockRenderLayerMap.INSTANCE.putBlock(EMBlocks.BROWN_MUSHROOM.ladder, RenderLayer.getCutoutMipped());

    }

    private void addBoatRenderer(EntityType<EMBoatEntity> boat) {
        EntityRendererRegistry.INSTANCE.register(boat, (dispatcher, context) -> new BoatEntityRenderer(dispatcher));
    }

    private void addSigns(EMSignBlock... signs) {
        for (EMSignBlock sign : signs) {
            addSign(sign);
        }
    }

    private void addSign(EMSignBlock sign) {
        Identifier texture = sign.getTexture();

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, texture));
    }

}
