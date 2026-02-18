package com.makson;

import com.makson.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;

public class ModItemGroups {
    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
                .register(entries -> {
                    entries.getContext()
                            .holders()
                            .lookupOrThrow(Registries.ENCHANTMENT)
                            .get(ModEnchantments.AERIAL_SWIFTNESS)
                            .ifPresent(holder -> {
                                Enchantment enchantment = holder.value();
                                int max = enchantment.getMaxLevel();

                                ItemStack itemStack = new ItemStack(Items.ENCHANTED_BOOK);
                                ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);

                                mutable.set(holder, max);
                                EnchantmentHelper.setEnchantments(itemStack, mutable.toImmutable());

                                entries.accept(itemStack);
                            });
                });
    }
}
