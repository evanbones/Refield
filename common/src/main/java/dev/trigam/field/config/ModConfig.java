package dev.trigam.field.config;

import dev.trigam.field.Constants;
import dev.trigam.field.platform.Services;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = Services.PLATFORM.getConfigDirectory().resolve(Constants.MOD_ID + ".json").toFile();
    private static ModConfig INSTANCE;

    @SerializedName("bannerLayers")
    public int bannerLayers = 32;

    @SerializedName("bannerTooltipLayers")
    public int bannerTooltipLayers = 8;

    @SerializedName("bannerStackSize")
    public int bannerStackSize = 64;

    @SerializedName("loomTooltip")
    public boolean loomTooltip = true;

    @SerializedName("wearableBanners")
    public boolean wearableBanners = true;

    public static ModConfig get() {
        if (INSTANCE == null) {
            load();
        }
        return INSTANCE;
    }

    public static void load() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                INSTANCE = GSON.fromJson(reader, ModConfig.class);
            } catch (Exception e) {
                Constants.LOG.error("Failed to load " + Constants.MOD_ID + ".json", e);
                INSTANCE = new ModConfig();
                save();
            }
        } else {
            INSTANCE = new ModConfig();
            save();
        }
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(INSTANCE, writer);
        } catch (IOException e) {
            Constants.LOG.error("Failed to save " + Constants.MOD_ID + ".json", e);
        }
    }

    public static Screen createScreen(Screen parent) {
        YetAnotherConfigLib.Builder builder = YetAnotherConfigLib.createBuilder()
                .title(Component.translatable("config.field.title"))
                .save(ModConfig::save);

        ConfigCategory.Builder general = ConfigCategory.createBuilder()
                .name(Component.translatable("config.field.category.general"))
                .option(createIntOption("bannerLayers", 32, () -> get().bannerLayers, val -> get().bannerLayers = val, 0, 64))
                .option(createIntOption("bannerTooltipLayers", 8, () -> get().bannerTooltipLayers, val -> get().bannerTooltipLayers = val, 0, 64))
                .option(createIntOption("bannerStackSize", 64, () -> get().bannerStackSize, val -> get().bannerStackSize = val, 0, 64))
                .option(createBoolOption("loomTooltip", true, () -> get().loomTooltip, val -> get().loomTooltip = val))
                .option(createBoolOption("wearableBanners", true, () -> get().wearableBanners, val -> get().wearableBanners = val));

        return builder.category(general.build()).build().generateScreen(parent);
    }

    private static Option<Boolean> createBoolOption(String name, boolean defaultValue, Supplier<Boolean> getter, Consumer<Boolean> setter) {
        return Option.<Boolean>createBuilder()
                .name(Component.translatable("config.field.option." + name))
                .binding(defaultValue, getter, setter)
                .controller(TickBoxControllerBuilder::create)
                .build();
    }

    private static Option<Integer> createIntOption(String name, int defaultValue, Supplier<Integer> getter, Consumer<Integer> setter, int min, int max) {
        return Option.<Integer>createBuilder()
                .name(Component.translatable("config.field.option." + name))
                .binding(defaultValue, getter, setter)
                .controller(opt -> IntegerFieldControllerBuilder.create(opt).range(min, max))
                .build();
    }
}