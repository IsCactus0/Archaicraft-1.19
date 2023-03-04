package net.iscactus.archaicraft.item;

import com.mojang.blaze3d.shaders.Effect;
import net.iscactus.archaicraft.Archaicraft;
import net.iscactus.archaicraft.block.ModBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Collections;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Archaicraft.MOD_ID);

    public static RegistryObject<Item> ALOE_LEAF = ITEMS.register("aloe_leaf",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ARCHAICRAFT_TAB).food(new FoodProperties.Builder().nutrition(1).saturationMod(2f).fast().build())));
    public static RegistryObject<Item> COTTON_SEEDS = ITEMS.register("cotton_seeds",
            () -> new ItemNameBlockItem(ModBlocks.COTTON_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.ARCHAICRAFT_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
