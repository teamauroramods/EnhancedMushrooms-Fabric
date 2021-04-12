package com.github.teamaurora.enhanced_mushrooms.init;

import com.github.teamaurora.enhanced_mushrooms.EnhancedMushrooms;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MushroomStewItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EMItems {
    public static final Item ROASTED_MUSHROOMS = new Item(new Item.Settings().food(EMFoods.ROASTED_MUSHROOMS).food(EMFoods.ROASTED_MUSHROOMS).group(ItemGroup.FOOD));
    public static final MushroomStewItem BEEF_STEW = new MushroomStewItem(new Item.Settings().maxCount(1).food(EMFoods.BEEF_STEW).food(EMFoods.BEEF_STEW).group(ItemGroup.FOOD));

    public static void init(){
        Registry.register(Registry.ITEM, new Identifier(EnhancedMushrooms.MOD_ID, "roasted_mushrooms"), ROASTED_MUSHROOMS);
        Registry.register(Registry.ITEM, new Identifier(EnhancedMushrooms.MOD_ID, "beef_stew"), BEEF_STEW);
    }
}