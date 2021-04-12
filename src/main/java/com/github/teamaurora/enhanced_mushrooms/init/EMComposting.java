package com.github.teamaurora.enhanced_mushrooms.init;

import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemConvertible;

public class EMComposting {

    public static void init() {
        registerCompostableItem(0.3F, EMItems.ROASTED_MUSHROOMS);
    }

    public static void registerCompostableItem(float chance, ItemConvertible item)
    {
        if (item.asItem() != net.minecraft.item.Items.AIR)
        {
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(item.asItem(), chance);
        }
    }

}
