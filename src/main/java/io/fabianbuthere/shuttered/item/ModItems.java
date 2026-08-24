package io.fabianbuthere.shuttered.item;

import io.fabianbuthere.shuttered.Shuttered;
import io.fabianbuthere.shuttered.block.ModBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Shuttered.MODID);

    public static final List<String> SHUTTER_VARIANTS = List.of("copper");

    public static final DeferredItem<BlockItem> COPPER_SHUTTERS_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("copper_shutters", ModBlocks.COPPER_SHUTTERS);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
