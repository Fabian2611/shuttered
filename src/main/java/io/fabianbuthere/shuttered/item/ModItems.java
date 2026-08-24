package io.fabianbuthere.shuttered.item;

import io.fabianbuthere.shuttered.Shuttered;
import io.fabianbuthere.shuttered.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Shuttered.MODID);

    public static final List<String> SHUTTER_VARIANTS = List.of("copper", "dark_oak", "acacia", "iron", "spruce", "warped");

    public static final DeferredItem<BlockItem> COPPER_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("copper_shutters", ModBlocks.COPPER_SHUTTERS);

    public static final DeferredItem<BlockItem> DARK_OAK_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("dark_oak_shutters", ModBlocks.DARK_OAK_SHUTTERS);

    public static final DeferredItem<BlockItem> ACACIA_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("acacia_shutters", ModBlocks.ACACIA_SHUTTERS);

    public static final DeferredItem<BlockItem> IRON_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("iron_shutters", ModBlocks.IRON_SHUTTERS);

    public static final DeferredItem<BlockItem> SPRUCE_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("spruce_shutters", ModBlocks.SPRUCE_SHUTTERS);

    public static final DeferredItem<BlockItem> WARPED_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("warped_shutters", ModBlocks.WARPED_SHUTTERS);

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
