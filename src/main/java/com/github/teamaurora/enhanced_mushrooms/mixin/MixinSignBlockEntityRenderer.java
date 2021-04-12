package com.github.teamaurora.enhanced_mushrooms.mixin;

import com.github.teamaurora.enhanced_mushrooms.block.EMSignBlock;
import com.github.teamaurora.enhanced_mushrooms.block.EMWallSignBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.Block;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Mixin(SignBlockEntityRenderer.class)
@Environment(EnvType.CLIENT)
public class MixinSignBlockEntityRenderer {
    @Inject(method = "getModelTexture", at = @At("HEAD"), cancellable = true)
    private static void getModelTexture(Block block, CallbackInfoReturnable<SpriteIdentifier> info) {
        if (block instanceof EMSignBlock) {
            Identifier texture = ((EMSignBlock) block).getTexture();
            info.setReturnValue(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, texture));
        }
        if (block instanceof EMWallSignBlock) {
            Identifier texture = ((EMWallSignBlock) block).getTexture();
            info.setReturnValue(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, texture));
        }
    }
}
