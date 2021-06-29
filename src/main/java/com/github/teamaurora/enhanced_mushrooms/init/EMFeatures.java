package com.github.teamaurora.enhanced_mushrooms.init;

import com.github.teamaurora.enhanced_mushrooms.EnhancedMushrooms;
import com.github.teamaurora.enhanced_mushrooms.util.RegistryHelper;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

import java.util.function.Predicate;

public class EMFeatures {
    private static final Predicate<BiomeSelectionContext> MUSHROOM_BIOMES = BiomeSelectors.categories(Biome.Category.MUSHROOM);
    private static final Predicate<BiomeSelectionContext> DARK_FOREST = BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST, BiomeKeys.DARK_FOREST_HILLS);

    private static void doModifications()
    {
        mushroomModifications();
    }

    private static void mushroomModifications() {
        //Huge Red Mushroom
        BiomeModifications.create(EnhancedMushrooms.id("remove_vanilla_red_mushroom_trees"))
                .add(ModificationPhase.REPLACEMENTS, MUSHROOM_BIOMES, (c)->{
                    if(c.getGenerationSettings().removeBuiltInFeature(ConfiguredFeatures.HUGE_RED_MUSHROOM))
                    {
                        c.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, registryKey(EMFeatures.HUGE_RED_MUSHROOM));
                    }
                });
        //Huge Brown Mushroom
        BiomeModifications.create(EnhancedMushrooms.id("remove_vanilla_brown_mushroom_trees"))
                .add(ModificationPhase.REPLACEMENTS, MUSHROOM_BIOMES, (c)->{
                    if(c.getGenerationSettings().removeBuiltInFeature(ConfiguredFeatures.HUGE_BROWN_MUSHROOM))
                    {
                        c.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, registryKey(EMFeatures.HUGE_BROWN_MUSHROOM));
                    }
                });

        //Mushroom Fields Vegetation's
        BiomeModifications.create(EnhancedMushrooms.id("remove_mushroom_field_vegetation"))
                .add(ModificationPhase.REPLACEMENTS, MUSHROOM_BIOMES, (c)->{
                    if(c.getGenerationSettings().removeBuiltInFeature(ConfiguredFeatures.MUSHROOM_FIELD_VEGETATION))
                    {
                        c.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, registryKey(EMFeatures.MUSHROOM_FIELD_VEGETATION));
                    }
                });

        /*
        //Huge Red Mushroom Dark
        BiomeModifications.create(EnhancedMushrooms.id("remove_vanilla_red_mushroom_dark_trees"))
                .add(ModificationPhase.REPLACEMENTS, DARK_FOREST, (c)->{
                    if(c.getGenerationSettings().removeBuiltInFeature(ConfiguredFeatures.DARK_FOREST_VEGETATION_RED))
                    {
                        c.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, registryKey(EMFeatures.HUGE_RED_MUSHROOM));
                    }
                });

        //Huge Brown Mushroom Dark
        BiomeModifications.create(EnhancedMushrooms.id("remove_vanilla_brown_mushroom_dark_trees"))
                .add(ModificationPhase.REPLACEMENTS, DARK_FOREST, (c)->{
                    if(c.getGenerationSettings().removeBuiltInFeature(ConfiguredFeatures.DARK_FOREST_VEGETATION_BROWN))
                    {
                        c.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, registryKey(EMFeatures.DARK_FOREST_VEGETATION_BROWN));
                    }
                });
         */
    }

    protected static final BlockState RED_MUSHROOM_BLOCK;
    protected static final BlockState BROWN_MUSHROOM_BLOCK;
    protected static final BlockState RED_MUSHROOM_STEM;
    protected static final BlockState BROWN_MUSHROOM_STEM;

    static {
        RED_MUSHROOM_BLOCK = Blocks.RED_MUSHROOM_BLOCK.getDefaultState().with(MushroomBlock.DOWN, false);
        BROWN_MUSHROOM_BLOCK = Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState().with(MushroomBlock.UP, true).with(MushroomBlock.DOWN, false);
        RED_MUSHROOM_STEM = EMBlocks.RED_MUSHROOM.log.getDefaultState();
        BROWN_MUSHROOM_STEM = EMBlocks.BROWN_MUSHROOM.log.getDefaultState();
    }

    public static final ConfiguredFeature<?, ?> HUGE_RED_MUSHROOM = Feature.HUGE_RED_MUSHROOM.configure(new HugeMushroomFeatureConfig(new SimpleBlockStateProvider(RED_MUSHROOM_BLOCK), new SimpleBlockStateProvider(RED_MUSHROOM_STEM), 2));
    public static final ConfiguredFeature<?, ?> HUGE_BROWN_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(new SimpleBlockStateProvider(BROWN_MUSHROOM_BLOCK), new SimpleBlockStateProvider(BROWN_MUSHROOM_STEM), 2));

    public static final ConfiguredFeature<?, ?> DARK_FOREST_VEGETATION_RED = Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(EMFeatures.HUGE_RED_MUSHROOM.withChance(0.025F), EMFeatures.HUGE_BROWN_MUSHROOM.withChance(0.05F), ConfiguredFeatures.DARK_OAK.withChance(0.6666667F), ConfiguredFeatures.BIRCH.withChance(0.2F), ConfiguredFeatures.FANCY_OAK.withChance(0.1F)), ConfiguredFeatures.OAK)).decorate(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DARK_FOREST_VEGETATION_BROWN = Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(EMFeatures.HUGE_BROWN_MUSHROOM.withChance(0.025F), EMFeatures.HUGE_RED_MUSHROOM.withChance(0.05F), ConfiguredFeatures.DARK_OAK.withChance(0.6666667F), ConfiguredFeatures.BIRCH.withChance(0.2F), ConfiguredFeatures.FANCY_OAK.withChance(0.1F)), ConfiguredFeatures.OAK)).decorate(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT));

    //public static final ConfiguredFeature<?, ?> DARK_FOREST_VEGETATION_BROWN = Feature.RANDOM_SELECTOR.configure("dark_forest_vegetation_brown", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(HUGE_BROWN_MUSHROOM.withChance(0.025F), HUGE_RED_MUSHROOM.withChance(0.05F), ConfiguredFeatures.DARK_OAK.withChance(0.6666667F), ConfiguredFeatures.BIRCH.withChance(0.2F), ConfiguredFeatures.FANCY_OAK.withChance(0.1F)), ConfiguredFeatures.OAK)).decorate(ConfiguredFeatures.Decorators.DARK_OAK_TREE_HEIGHTMAP));
    //public static final ConfiguredFeature<?, ?> DARK_FOREST_VEGETATION_RED = Feature.RANDOM_SELECTOR.configure("dark_forest_vegetation_red", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(HUGE_RED_MUSHROOM.withChance(0.025F), HUGE_BROWN_MUSHROOM.withChance(0.05F), ConfiguredFeatures.DARK_OAK.withChance(0.6666667F), ConfiguredFeatures.BIRCH.withChance(0.2F), ConfiguredFeatures.FANCY_OAK.withChance(0.1F)), ConfiguredFeatures.OAK)).decorate(ConfiguredFeatures.Decorators.DARK_OAK_TREE_HEIGHTMAP));

    public static final ConfiguredFeature<?, ?> MUSHROOM_FIELD_VEGETATION = Feature.RANDOM_BOOLEAN_SELECTOR.configure(new RandomBooleanFeatureConfig(() -> { return HUGE_RED_MUSHROOM; }, () -> { return HUGE_BROWN_MUSHROOM; })).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP);

    public static void init()
    {
        RegistryHelper.register(BuiltinRegistries.CONFIGURED_FEATURE, ConfiguredFeature.class, EMFeatures.class);

        doModifications();
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(ConfiguredFeature carver)
    {
        return BuiltinRegistries.CONFIGURED_FEATURE.getKey(carver).get();
    }
}
