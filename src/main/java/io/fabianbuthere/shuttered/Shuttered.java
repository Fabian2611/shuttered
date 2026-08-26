package io.fabianbuthere.shuttered;

import com.mojang.logging.LogUtils;
import io.fabianbuthere.shuttered.block.ModBlocks;
import io.fabianbuthere.shuttered.item.ModCreativeModeTabs;
import io.fabianbuthere.shuttered.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import org.slf4j.Logger;

@Mod(Shuttered.MODID)
public class Shuttered {
    public static final String MODID = "shuttered";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Shuttered(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Loading.");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            for (DeferredItem<BlockItem> item : ModItems.SHUTTERS) {
                event.accept(item);
            }
        }
    }
}
