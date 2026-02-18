package com.makson;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> AERIAL_SWIFTNESS = key("aerial_swiftness");

    private static ResourceKey<Enchantment> key(String path) {
        Identifier id = Identifier.fromNamespaceAndPath(HappyGhastOverdrive.MOD_ID, path);
        return ResourceKey.create(Registries.ENCHANTMENT, id);
    }

    public static void initialize() {
        HappyGhastOverdrive.LOGGER.info("Registering Enchantments");
    }
}
