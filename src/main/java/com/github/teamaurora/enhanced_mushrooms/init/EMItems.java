package com.github.teamaurora.enhanced_mushrooms.init;

import com.chocohead.mm.api.ClassTinkerers;
import com.github.teamaurora.enhanced_mushrooms.EnhancedMushrooms;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.StewItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EMItems {
    public static final Item ROASTED_MUSHROOMS = new Item(new Item.Settings().food(EMFoods.ROASTED_MUSHROOMS).food(EMFoods.ROASTED_MUSHROOMS).group(ItemGroup.FOOD));
    public static final StewItem BEEF_STEW = new StewItem(new Item.Settings().maxCount(1).food(EMFoods.BEEF_STEW).food(EMFoods.BEEF_STEW).group(ItemGroup.FOOD));

    public static final Item RED_MUSHROOM_BOAT = new BoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "RED_MUSHROOM"), (new Item.Settings()).maxCount(1).group(ItemGroup.TRANSPORTATION));
    public static final Item BROWN_MUSHROOM_BOAT = new BoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "BROWN_MUSHROOM"), (new Item.Settings()).maxCount(1).group(ItemGroup.TRANSPORTATION));


    public static void init() {
        Registry.register(Registry.ITEM, new Identifier(EnhancedMushrooms.MOD_ID, "roasted_mushrooms"), ROASTED_MUSHROOMS);
        Registry.register(Registry.ITEM, new Identifier(EnhancedMushrooms.MOD_ID, "beef_stew"), BEEF_STEW);

        Registry.register(Registry.ITEM, EnhancedMushrooms.id("red_mushroom_boat"), RED_MUSHROOM_BOAT);
        Registry.register(Registry.ITEM, EnhancedMushrooms.id("brown_mushroom_boat"), BROWN_MUSHROOM_BOAT);
    }
}