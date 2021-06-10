package com.github.teamaurora.enhanced_mushrooms.block;

import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class EMBoat {
    private final Item item;
    private final Item planks;
    private final Identifier skin;
    private final BoatEntity.Type vanilla;

    public EMBoat(Item item, Item planks, Identifier skin) {
        this(item, planks, skin, BoatEntity.Type.OAK);
    }

    public EMBoat(Item item, Item planks, Identifier skin, BoatEntity.Type vanilla) {
        this.item = item;
        this.planks = planks;
        this.skin = skin;
        this.vanilla = vanilla;
    }

    public Item asItem() {
        return item;
    }

    public Item asPlanks() {
        return planks;
    }

    public Identifier getSkin() {
        return skin;
    }

    public BoatEntity.Type getVanillaType() {
        return vanilla;
    }
}
