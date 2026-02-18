package com.makson.datagen.language;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class HappyGhastOverdriveRussianLangProvider extends FabricLanguageProvider {
    public HappyGhastOverdriveRussianLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "ru_ru", registryLookup);
    }

    @Override
    public void generateTranslations(@NotNull HolderLookup.Provider provider, @NotNull TranslationBuilder translationBuilder) {
        translationBuilder.add("enchantment.happy_ghast_overdrive.aerial_swiftness", "Небесная стремительность");
    }
}
