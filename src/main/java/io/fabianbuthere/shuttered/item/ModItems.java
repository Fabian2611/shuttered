package io.fabianbuthere.shuttered.item;

import io.fabianbuthere.shuttered.Shuttered;
import io.fabianbuthere.shuttered.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Shuttered.MODID);

    public static final Set<String> SHUTTER_VARIANTS = Set.of("copper", "dark_oak", "acacia", "iron", "spruce", "warped", "jungle", "mangrove", "oak", "crimson", "bamboo", "birch", "cherry");

    public static final DeferredItem<BlockItem> COPPER_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("copper_shutters", ModBlocks.COPPER_SHUTTERS);

    public static final DeferredItem<BlockItem> DARK_OAK_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("dark_oak_shutters", ModBlocks.DARK_OAK_SHUTTERS);

    public static final DeferredItem<BlockItem> ACACIA_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("acacia_shutters", ModBlocks.ACACIA_SHUTTERS);

    public static final DeferredItem<BlockItem> JUNGLE_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("jungle_shutters", ModBlocks.JUNGLE_SHUTTERS);

    public static final DeferredItem<BlockItem> IRON_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("iron_shutters", ModBlocks.IRON_SHUTTERS);

    public static final DeferredItem<BlockItem> SPRUCE_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("spruce_shutters", ModBlocks.SPRUCE_SHUTTERS);

    public static final DeferredItem<BlockItem> WARPED_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("warped_shutters", ModBlocks.WARPED_SHUTTERS);

    public static final DeferredItem<BlockItem> MANGROVE_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("mangrove_shutters", ModBlocks.MANGROVE_SHUTTERS);

    public static final DeferredItem<BlockItem> OAK_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("oak_shutters", ModBlocks.OAK_SHUTTERS);

    public static final DeferredItem<BlockItem> CRIMSON_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("crimson_shutters", ModBlocks.CRIMSON_SHUTTERS);

    public static final DeferredItem<BlockItem> BAMBOO_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("bamboo_shutters", ModBlocks.BAMBOO_SHUTTERS);

    public static final DeferredItem<BlockItem> BIRCH_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("birch_shutters", ModBlocks.BIRCH_SHUTTERS);

    public static final DeferredItem<BlockItem> CHERRY_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("cherry_shutters", ModBlocks.CHERRY_SHUTTERS);

    public static final Set<DeferredItem<BlockItem>> SHUTTERS = Set.of(
            COPPER_SHUTTERS_ITEM, ACACIA_SHUTTERS_ITEM, JUNGLE_SHUTTERS_ITEM, DARK_OAK_SHUTTERS_ITEM, IRON_SHUTTERS_ITEM, SPRUCE_SHUTTERS_ITEM,
            WARPED_SHUTTERS_ITEM, MANGROVE_SHUTTERS_ITEM, OAK_SHUTTERS_ITEM, CRIMSON_SHUTTERS_ITEM, BAMBOO_SHUTTERS_ITEM, BIRCH_SHUTTERS_ITEM, CHERRY_SHUTTERS_ITEM
    );

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
