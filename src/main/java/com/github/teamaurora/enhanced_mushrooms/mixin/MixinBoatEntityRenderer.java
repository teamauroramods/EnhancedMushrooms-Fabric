package com.github.teamaurora.enhanced_mushrooms.mixin;

import com.github.teamaurora.enhanced_mushrooms.block.EMBoatEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(BoatEntityRenderer.class)
@Environment(EnvType.CLIENT)
public abstract class MixinBoatEntityRenderer {
    @Shadow
    public abstract Identifier getTexture(BoatEntity boatEntity);

    @ModifyArgs(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/model/BoatEntityModel;getLayer(Lnet/minecraft/util/Identifier;)Lnet/minecraft/client/render/RenderLayer;"))
    private void renderTexture(Args args, BoatEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertices, int light) {
        if (entity instanceof EMBoatEntity) {
            args.set(0, this.getTexture(entity));
        }
    }

    @Inject(method = "getTexture", at = @At("HEAD"), cancellable = true)
    private void getTexture(BoatEntity boat, CallbackInfoReturnable<Identifier> info) {
        if (boat instanceof EMBoatEntity emBoat) {
            info.setReturnValue(emBoat.getBoatSkin());
        }
    }
}