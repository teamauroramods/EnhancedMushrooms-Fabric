package com.github.teamaurora.enhanced_mushrooms.init;

import com.github.teamaurora.enhanced_mushrooms.EnhancedMushrooms;
import com.github.teamaurora.enhanced_mushrooms.util.WoodBlocks;
import net.minecraft.block.MapColor;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class EMBlocks {
    private static final Map<Identifier, WoodBlocks> WOOD_BLOCKS = new LinkedHashMap<>();

    public static WoodBlocks RED_MUSHROOM = add("red_mushroom", WoodBlocks.generate("red_mushroom", MapColor.RED));
    public static WoodBlocks BROWN_MUSHROOM = add("brown_mushroom", WoodBlocks.generate("brown_mushroom", MapColor.BROWN));

    public static void init() {
        for (Identifier id : WOOD_BLOCKS.keySet()) {
            WOOD_BLOCKS.get(id).register().registerItems().initBoat();
        }
    }

    private static <W extends WoodBlocks> W add(String name, W set) {
        WOOD_BLOCKS.put(EnhancedMushrooms.id(name), set);
        return set;
    }
}