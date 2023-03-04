package net.iscactus.archaicraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ARCHAICRAFT_TAB = new CreativeModeTab("archaicrafttab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ALOE_LEAF.get());
        }
    };
}
