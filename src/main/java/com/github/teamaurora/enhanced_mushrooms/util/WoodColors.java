package com.github.teamaurora.enhanced_mushrooms.util;

import net.minecraft.block.MaterialColor;

/*
 * Shamelessly stolen from Terrestria
 */
public class WoodColors {
    public static final WoodColors RED_MUSH;
    public static final WoodColors BROWN_MUSH;

    static {
        RED_MUSH = new WoodColors();
        RED_MUSH.bark = MaterialColor.RED;
        RED_MUSH.planks = MaterialColor.RED;
        RED_MUSH.leaves = MaterialColor.RED;
        BROWN_MUSH = new WoodColors();
        BROWN_MUSH.bark = MaterialColor.BROWN;
        BROWN_MUSH.planks = MaterialColor.BROWN;
        BROWN_MUSH.leaves = MaterialColor.BROWN;
    }

    public MaterialColor bark;
    public MaterialColor planks;
    public MaterialColor leaves = MaterialColor.FOLIAGE;
}
