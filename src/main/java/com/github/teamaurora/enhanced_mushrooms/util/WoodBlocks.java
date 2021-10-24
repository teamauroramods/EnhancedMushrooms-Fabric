package com.github.teamaurora.enhanced_mushrooms.util;

import com.chocohead.mm.api.ClassTinkerers;
import com.github.teamaurora.enhanced_mushrooms.EnhancedMushrooms;
import com.github.teamaurora.enhanced_mushrooms.block.EMSignType;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.SignType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/*
 * Shamelessly stolen from Terrestria
 */

public class WoodBlocks {
    public static List<Block> signBlocks = new LinkedList<>();
    public static Map<Block, Block> stripMap = new HashMap<>();
    public Block log;
    public Block wood;
    public Block planks;
    public SlabBlock slab;
    public StairsBlock stairs;
    public FenceBlock fence;
    public FenceGateBlock fenceGate;
    public DoorBlock door;
    public AbstractButtonBlock button;
    public AbstractPressurePlateBlock pressurePlate;
    public SignBlock sign;
    public WallSignBlock wallSign;
    public TrapdoorBlock trapdoor;
    public Block strippedLog;
    public Block strippedWood;
    public BoatItem boat;
    public BoatEntity.Type boatType;
    public String name;
    public MapColor colors;
    public FlammableBlockRegistry registry;

    public WoodBlocks(Block log, Block wood, Block planks, SlabBlock slab, StairsBlock stairs, FenceBlock fence, FenceGateBlock fenceGate, DoorBlock door, AbstractButtonBlock button, AbstractPressurePlateBlock pressurePlate, SignBlock sign, WallSignBlock wallSign, TrapdoorBlock trapdoor, Block strippedLog, Block strippedWood, String name, MapColor colors, FlammableBlockRegistry registry) {
        this.log = log;
        this.wood = wood;
        this.planks = planks;
        this.slab = slab;
        this.stairs = stairs;
        this.fence = fence;
        this.fenceGate = fenceGate;
        this.door = door;
        this.button = button;
        this.pressurePlate = pressurePlate;
        this.sign = sign;
        this.wallSign = wallSign;
        this.trapdoor = trapdoor;
        this.strippedLog = strippedLog;
        this.strippedWood = strippedWood;
        this.name = name;
        this.colors = colors;
        this.registry = registry;
    }

    public static WoodBlocks generate(String name, MapColor colors) {
        return generate(name, colors, FlammableBlockRegistry.getDefaultInstance());
    }

    public static WoodBlocks generate(String name, MapColor colors, FlammableBlockRegistry registry) {

        Block log;
        Block wood;
        Block planks;
        SlabBlock slab;
        StairsBlock stairs;
        FenceBlock fence;
        FenceGateBlock fenceGate;
        DoorBlock door;
        AbstractButtonBlock button;
        AbstractPressurePlateBlock pressurePlate;
        SignBlock sign;
        WallSignBlock wallSign;
        TrapdoorBlock trapdoor;
        Block strippedLog;
        Block strippedWood;

        planks = new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(colors).breakByTool(FabricToolTags.AXES));
        slab = new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(colors).breakByTool(FabricToolTags.AXES));
        stairs = new StairsBlock(planks.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).mapColor(colors).breakByTool(FabricToolTags.AXES));
        fence = new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(colors).breakByTool(FabricToolTags.AXES));
        fenceGate = new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(colors).breakByTool(FabricToolTags.AXES));
        door = new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).mapColor(colors).breakByTool(FabricToolTags.AXES));
        button = new WoodenButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).mapColor(colors).breakByTool(FabricToolTags.AXES));
        pressurePlate = new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).mapColor(colors).breakByTool(FabricToolTags.AXES));
        trapdoor = new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).mapColor(colors).breakByTool(FabricToolTags.AXES));

        SignType signType = EMSignType.register(new EMSignType(name));

        sign = new SignBlock(AbstractBlock.Settings.of(Material.WOOD).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD), signType);
        wallSign = new WallSignBlock(AbstractBlock.Settings.of(Material.WOOD).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD).dropsLike(sign), signType);

        strippedLog = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(colors).breakByTool(FabricToolTags.AXES));
        strippedWood = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(colors).breakByTool(FabricToolTags.AXES));
        log = Blocks.createLogBlock(colors, colors);
        wood = Blocks.createLogBlock(colors, colors);


        stripMap.put(log, strippedLog);

        return new WoodBlocks(log, wood, planks, slab, stairs, fence, fenceGate, door, button, pressurePlate, sign, wallSign, trapdoor, strippedLog, strippedWood, name, colors, registry);

    }

    private static <T extends Block> T register(String name, T block) {
        return Registry.register(Registry.BLOCK, EnhancedMushrooms.id(name), block);
    }

    private static BlockItem registerBlockItem(String name, Block block, Item.Settings settings) {
        BlockItem item = new BlockItem(block, settings);
        item.appendBlocks(Item.BLOCK_ITEMS, item);

        return Registry.register(Registry.ITEM, EnhancedMushrooms.id(name), item);
    }

    private static SignItem registerSignItem(String name, Block standing, Block wall, Item.Settings settings) {
        return Registry.register(Registry.ITEM, EnhancedMushrooms.id(name), new SignItem(settings, standing, wall));
    }

    private static <I extends Item> I registerItem(String name, I item) {
        return Registry.register(Registry.ITEM, EnhancedMushrooms.id(name), item);
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    public WoodBlocks initBoat() {
        boatType = ClassTinkerers.getEnum(BoatEntity.Type.class, "RED_MUSHROOM");
        boat = new BoatItem(boatType, new Item.Settings().maxCount(1).group(ItemGroup.TRANSPORTATION));

        return this;
    }

    public WoodBlocks register() {
        registerManufactured();

        register("stripped_" + name + "_stem", strippedLog);
        register("stripped_" + name + "_hyphae", strippedWood);
        register(name + "_stem", log);
        register(name + "_hyphae", wood);

        this.addTreeFireInfo();

        return this;
    }

    public WoodBlocks registerManufactured() {
        register(name + "_planks", planks);
        register(name + "_slab", slab);
        register(name + "_stairs", stairs);
        register(name + "_fence", fence);
        register(name + "_fence_gate", fenceGate);
        register(name + "_door", door);
        register(name + "_button", button);
        register(name + "_pressure_plate", pressurePlate);
        register(name + "_trapdoor", trapdoor);

        register(name + "_sign", sign);
        register(name + "_wall_sign", wallSign);

        signBlocks.add(sign);
        signBlocks.add(wallSign);

        this.addManufacturedFireInfo();

        FuelRegistry.INSTANCE.add(this.fence, 300);
        FuelRegistry.INSTANCE.add(this.fenceGate, 300);

        return this;
    }

    public WoodBlocks registerItems() {
        registerBlockItem(name + "_stem", this.log, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
        registerBlockItem(name + "_hyphae", this.wood, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
        registerBlockItem("stripped_" + name + "_stem", this.strippedLog, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
        registerBlockItem("stripped_" + name + "_hyphae", this.strippedWood, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
        registerBlockItem(name + "_planks", this.planks, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
        registerBlockItem(name + "_slab", this.slab, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
        registerBlockItem(name + "_stairs", this.stairs, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
        registerBlockItem(name + "_fence", this.fence, new FabricItemSettings().group(ItemGroup.DECORATIONS));
        registerBlockItem(name + "_fence_gate", this.fenceGate, new FabricItemSettings().group(ItemGroup.REDSTONE));
        registerBlockItem(name + "_door", this.door, new FabricItemSettings().group(ItemGroup.REDSTONE));
        registerBlockItem(name + "_button", this.button, new FabricItemSettings().group(ItemGroup.REDSTONE));
        registerBlockItem(name + "_pressure_plate", this.pressurePlate, new FabricItemSettings().group(ItemGroup.REDSTONE));
        registerBlockItem(name + "_trapdoor", this.trapdoor, new FabricItemSettings().group(ItemGroup.REDSTONE));
        registerSignItem(name + "_sign", this.sign, this.wallSign, new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS));

        //registerItem(name + "_boat", boat);

        return this;
    }

    public void addTreeFireInfo() {
        registry.add(log, 5, 5);
        registry.add(strippedLog, 5, 5);

        if (wood != log) {
            registry.add(wood, 5, 5);
        }

        if (strippedWood != strippedLog) {
            registry.add(strippedWood, 5, 5);
        }
    }

    public void addManufacturedFireInfo() {
        registry.add(planks, 5, 20);
        registry.add(slab, 5, 20);
        registry.add(stairs, 5, 20);
        registry.add(fence, 5, 20);
        registry.add(fenceGate, 5, 20);
    }

}
