package com.makson;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HappyGhastOverdrive implements ModInitializer {
    public static final String MOD_ID = "happy_ghast_overdrive";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModEnchantments.initialize();
        ModItemGroups.register();
        LootModifier.register();
    }
}