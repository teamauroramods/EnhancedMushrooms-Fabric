package com.github.teamaurora.enhanced_mushrooms.init;

import net.minecraft.item.FoodComponent;

public class EMFoods {
    public static final FoodComponent ROASTED_MUSHROOMS = new FoodComponent.Builder().hunger(2).saturationModifier((0.2F)).build();
    public static final FoodComponent BEEF_STEW = new FoodComponent.Builder().hunger(10).saturationModifier(0.8F).build();
}

