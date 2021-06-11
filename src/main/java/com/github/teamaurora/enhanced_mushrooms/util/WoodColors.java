package com.github.teamaurora.enhanced_mushrooms.util;

import net.minecraft.block.MapColor;

/*
 * Shamelessly stolen from Terrestria
 */
public class WoodColors {
    public static final WoodColors RED_MUSH;
    public static final WoodColors BROWN_MUSH;

    static {
        RED_MUSH = new WoodColors();
        RED_MUSH.bark = MapColor.RED;
        RED_MUSH.planks = MapColor.RED;
        BROWN_MUSH = new WoodColors();
        BROWN_MUSH.bark = MapColor.BROWN;
        BROWN_MUSH.planks = MapColor.BROWN;
    }

    public MapColor bark;
    public MapColor planks;
}
