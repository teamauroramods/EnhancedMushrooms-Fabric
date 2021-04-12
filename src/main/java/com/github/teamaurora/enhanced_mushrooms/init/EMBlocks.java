package com.github.teamaurora.enhanced_mushrooms.init;

import com.github.teamaurora.enhanced_mushrooms.EnhancedMushrooms;
import com.github.teamaurora.enhanced_mushrooms.util.WoodBlocks;
import com.github.teamaurora.enhanced_mushrooms.util.WoodColors;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.github.teamaurora.enhanced_mushrooms.init.EMBoats.*;

public class EMBlocks {

    private static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();
    private static final Map<Identifier, BlockEntityType<?>> BLOCK_ENTITIES = new LinkedHashMap<>();
    private static final Map<Identifier, WoodBlocks> WOOD_BLOCKS = new LinkedHashMap<>();

    public static WoodBlocks RED_MUSHROOM = add("red_mushroom", WoodBlocks.generate("red_mushroom", WoodColors.RED_MUSH , () -> RED_MUSHROOM_BOAT));
    public static WoodBlocks BROWN_MUSHROOM = add("brown_mushroom", WoodBlocks.generate("brown_mushroom", WoodColors.BROWN_MUSH , () -> BROWN_MUSHROOM_BOAT));


    public static void init(){

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
        for (Identifier id : BLOCK_ENTITIES.keySet()) {
            Registry.register(Registry.BLOCK_ENTITY_TYPE, id, BLOCK_ENTITIES.get(id));
        }
        for (Identifier id : WOOD_BLOCKS.keySet()) {
            WOOD_BLOCKS.get(id).register().registerItems();
        }

    }

    private static <B extends Block, T extends BlockEntity> BlockEntityType<T> add(String name, B block, Supplier<T> supplier) {
        Identifier id = EnhancedMushrooms.id(name);
        BlockEntityType<T> blockEntity = BlockEntityType.Builder.create(supplier, block).build(null);
        BLOCK_ENTITIES.put(id, blockEntity);
        return blockEntity;
    }

    private static <W extends WoodBlocks> W add(String name, W set) {
        WOOD_BLOCKS.put(EnhancedMushrooms.id(name), set);
        return set;
    }

    private static <B extends Block> B add(String name, B block, ItemGroup tab) {
        return add(name, block, new BlockItem(block, new Item.Settings().group(tab)));
    }

    private static <B extends Block> B add(String name, B block, BlockItem item) {
        add(name, block);
        if (item != null) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            ITEMS.put(EnhancedMushrooms.id(name), item);
        }
        return block;
    }

    private static <B extends Block> B add(String name, B block) {
        BLOCKS.put(EnhancedMushrooms.id(name), block);
        return block;
    }

}
