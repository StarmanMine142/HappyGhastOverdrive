package com.makson.datagen.language;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class HappyGhastOverdriveUkrainianLangProvider extends FabricLanguageProvider {
    public HappyGhastOverdriveUkrainianLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "uk_ua", registryLookup);
    }

    @Override
    public void generateTranslations(@NotNull HolderLookup.Provider provider, @NotNull TranslationBuilder translationBuilder) {
        translationBuilder.add("enchantment.happy_ghast_overdrive.aerial_swiftness", "Повітряна спритність");
        translationBuilder.add("modmenu.descriptionTranslation.happy_ghast_overdrive", "Надає нове зачарування, аби покращити упряжі.");
    }
}
