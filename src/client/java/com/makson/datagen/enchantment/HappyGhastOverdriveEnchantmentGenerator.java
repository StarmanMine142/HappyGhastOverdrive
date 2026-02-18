package com.makson.datagen.enchantment;

import com.makson.HappyGhastOverdrive;
import com.makson.ModEnchantments;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentAttributeEffect;

import java.util.concurrent.CompletableFuture;


public class HappyGhastOverdriveEnchantmentGenerator extends FabricDynamicRegistryProvider {
    public HappyGhastOverdriveEnchantmentGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.addAll(registries.lookupOrThrow(Registries.ENCHANTMENT));
    }

    @Override
    public String getName() {
        return "Happy Ghast Overdrive Enchantments";
    }

    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.identifier()));
    }

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        register(
                context,
                ModEnchantments.AERIAL_SWIFTNESS,
                Enchantment.enchantment(
                                Enchantment.definition(
                                        context.lookup(Registries.ITEM).getOrThrow(ItemTags.HARNESSES),
                                        1,
                                        3,
                                        Enchantment.dynamicCost(10, 10),
                                        Enchantment.dynamicCost(25, 10),
                                        8,
                                        EquipmentSlotGroup.CHEST
                                )
                        )
                        .withEffect(
                                EnchantmentEffectComponents.ATTRIBUTES,
                                new EnchantmentAttributeEffect(
                                        Identifier.fromNamespaceAndPath(HappyGhastOverdrive.MOD_ID, "aerial_swiftness"),
                                        Attributes.FLYING_SPEED,
                                        LevelBasedValue.perLevel(0.01f, 0.025f),
                                        AttributeModifier.Operation.ADD_VALUE
                                )
                        )


        );
    }
}
