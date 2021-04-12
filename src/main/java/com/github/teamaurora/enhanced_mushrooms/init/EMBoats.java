package com.github.teamaurora.enhanced_mushrooms.init;

import com.github.teamaurora.enhanced_mushrooms.EnhancedMushrooms;
import com.github.teamaurora.enhanced_mushrooms.block.EMBoat;
import com.github.teamaurora.enhanced_mushrooms.block.EMBoatEntity;
import com.github.teamaurora.enhanced_mushrooms.util.WoodBlocks;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.github.teamaurora.enhanced_mushrooms.init.EMBlocks.*;

public class EMBoats {
    public static EntityType<EMBoatEntity> RED_MUSHROOM_BOAT;
    public static EntityType<EMBoatEntity> BROWN_MUSHROOM_BOAT;

    public static void init() {
        RED_MUSHROOM_BOAT = registerBoat("red_mushroom", RED_MUSHROOM, BoatEntity.Type.DARK_OAK);
        BROWN_MUSHROOM_BOAT = registerBoat("brown_mushroom", BROWN_MUSHROOM, BoatEntity.Type.DARK_OAK);
    }

    private static EntityType<EMBoatEntity> registerBoat(String name, WoodBlocks wood, BoatEntity.Type vanilla) {
        Identifier skin = EnhancedMushrooms.id("textures/entity/boat/" + name + ".png");
        EMBoat boat = new EMBoat(wood.boat, wood.planks.asItem(), skin, vanilla);

        EntityType<EMBoatEntity> type = FabricEntityTypeBuilder.<EMBoatEntity>create(SpawnGroup.MISC, (entity, world) -> new EMBoatEntity(entity, world, boat)).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();

        return Registry.register(Registry.ENTITY_TYPE, EnhancedMushrooms.id(name + "_boat"), type);
    }
}
