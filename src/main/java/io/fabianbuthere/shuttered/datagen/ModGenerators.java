package io.fabianbuthere.shuttered.datagen;

import io.fabianbuthere.shuttered.Shuttered;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Shuttered.MODID)
public class ModGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        gen.addProvider(event.includeClient(), new ModBlockStates(event.getGenerator().getPackOutput(), event.getExistingFileHelper()));
        gen.addProvider(event.includeClient(), new ModItemModels(event.getGenerator().getPackOutput(), event.getExistingFileHelper()));

        gen.addProvider(event.includeServer(), new ModBlockTags(event.getGenerator().getPackOutput(), event.getLookupProvider(), event.getExistingFileHelper()));
        gen.addProvider(event.includeServer(), new ModRecipeProvider(event.getGenerator().getPackOutput(), event.getLookupProvider()));
    }
}
