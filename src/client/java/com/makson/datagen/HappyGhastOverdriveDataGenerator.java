package com.makson.datagen;

import com.makson.datagen.enchantment.HappyGhastOverdriveEnchantmentGenerator;
import com.makson.datagen.language.HappyGhastOverdriveEnglishLangProvider;
import com.makson.datagen.language.HappyGhastOverdriveRussianLangProvider;
import com.makson.datagen.tag.HappyGhastOverdriveTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.jetbrains.annotations.NotNull;

public class HappyGhastOverdriveDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.ENCHANTMENT, HappyGhastOverdriveEnchantmentGenerator::bootstrap);

    }

    @Override
    public void onInitializeDataGenerator(@NotNull FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(HappyGhastOverdriveEnglishLangProvider::new);
        pack.addProvider(HappyGhastOverdriveRussianLangProvider::new);
        pack.addProvider(HappyGhastOverdriveEnchantmentGenerator::new);
        pack.addProvider(HappyGhastOverdriveTagProvider::new);
    }
}
