package com.github.teamaurora.enhanced_mushrooms.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import com.github.teamaurora.enhanced_mushrooms.init.EMBlocks;
import com.github.teamaurora.enhanced_mushrooms.init.EMItems;
import com.github.teamaurora.enhanced_mushrooms.util.WoodBlocks;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatEntity.class)
public abstract class MixinBoatEntity {
    @Shadow
    public abstract BoatEntity.Type getBoatType();

    @Inject(method = "asItem", at = @At(value = "HEAD"), cancellable = true)
    public void addEM(CallbackInfoReturnable<Item> cir) {
        if (this.getBoatType().equals(EMBlocks.RED_MUSHROOM.boatType)) {
            cir.setReturnValue(EMItems.RED_MUSHROOM_BOAT);
        } else if (this.getBoatType().equals((EMBlocks.BROWN_MUSHROOM.boatType))) {
            cir.setReturnValue(EMItems.BROWN_MUSHROOM_BOAT);
        }
    }
}
