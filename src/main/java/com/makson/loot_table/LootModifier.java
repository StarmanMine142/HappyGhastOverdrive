package com.makson.loot_table;

import com.makson.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;

public class LootModifier {
    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
                    if (!source.isBuiltin()) {
                        return;
                    }

                    HolderLookup.RegistryLookup<Enchantment> registryLookup = registries.lookupOrThrow(Registries.ENCHANTMENT);

                    if (BuiltInLootTables.PIGLIN_BARTERING.equals(key)) {
                        tableBuilder.modifyPools(poolBuilder -> poolBuilder.add(addEnchantmentBook(registryLookup, ModEnchantments.AERIAL_SWIFTNESS, 8)));
                    } else if (BuiltInLootTables.BASTION_TREASURE.equals(key)) {
                        tableBuilder.pool(LootPool.lootPool()
                                .add(EmptyLootItem.emptyItem().setWeight(9))
                                .add(addEnchantmentBook(registryLookup, ModEnchantments.AERIAL_SWIFTNESS, 1))
                                .build()
                        );
                    }
                }
        );
    }

    private static LootPoolSingletonContainer.Builder<?> addEnchantmentBook(HolderLookup.RegistryLookup<Enchantment> registryLookup, ResourceKey<Enchantment> resourceKey, int weight) {
        return LootItem.lootTableItem(Items.BOOK)
                .setWeight(weight)
                .apply(new EnchantRandomlyFunction.Builder().withEnchantment(registryLookup.getOrThrow(resourceKey)));
    }
}
