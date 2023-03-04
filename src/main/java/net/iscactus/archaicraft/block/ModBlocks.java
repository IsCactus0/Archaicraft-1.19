package net.iscactus.archaicraft.block;

import net.iscactus.archaicraft.Archaicraft;
import net.iscactus.archaicraft.block.custom.AloePlantBlock;
import net.iscactus.archaicraft.block.custom.CottonCropBlock;
import net.iscactus.archaicraft.item.ModCreativeModeTab;
import net.iscactus.archaicraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Archaicraft.MOD_ID);

    public static final RegistryObject<Block> ALOE_PLANT = registerBlock("aloe_plant",
            () -> new AloePlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> COTTON_CROP = BLOCKS.register("cotton_crop",
            () -> new CottonCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static final RegistryObject<Block> WALNUT_SAPLING = registerBlock("walnut_sapling",
            () -> new SaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> POTTED_WALNUT_SAPLING = registerBlock("potted_walnut_sapling",
            () -> new FlowerPotBlock(WALNUT_SAPLING.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModCreativeModeTab.ARCHAICRAFT_TAB)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}