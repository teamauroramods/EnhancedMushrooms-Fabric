package com.github.teamaurora.enhanced_mushrooms;

import com.chocohead.mm.api.ClassTinkerers;
import com.chocohead.mm.api.EnumAdder;
import com.github.teamaurora.enhanced_mushrooms.init.EMBlocks;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

public class EnhancedMushroomsEarlyRiser implements Runnable {
    @Override
    public void run() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();

        String boat = remapper.mapClassName("intermediary", "net.minecraft.class_1690$class_1692");
        String block = 'L' + remapper.mapClassName("intermediary", "net.minecraft.class_2248") + ';';

        EnumAdder enumBuilder = ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;");

        enumBuilder.addEnum("RED_MUSHROOM", () -> new Object[]{EMBlocks.RED_MUSHROOM.planks, "red_mushroom"});
        enumBuilder.addEnum("BROWN_MUSHROOM", () -> new Object[]{EMBlocks.BROWN_MUSHROOM.planks, "brown_mushroom"});

        enumBuilder.build();
    }
}
