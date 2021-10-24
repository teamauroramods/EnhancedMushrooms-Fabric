package com.github.teamaurora.enhanced_mushrooms;

import com.github.teamaurora.enhanced_mushrooms.init.EMBlocks;
import com.github.teamaurora.enhanced_mushrooms.init.EMComposting;
import com.github.teamaurora.enhanced_mushrooms.init.EMItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnhancedMushrooms implements ModInitializer {
    public static final String MOD_ID = "enhanced_mushrooms";
    public static final String MOD_NAME = "Enhanced Mushrooms";
    public static Logger LOGGER = LogManager.getLogger();

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

    public static Identifier id(String id) {
        return new Identifier(MOD_ID, id);
    }

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        EMBlocks.init();
        EMItems.init();
        EMComposting.init();
    }
}