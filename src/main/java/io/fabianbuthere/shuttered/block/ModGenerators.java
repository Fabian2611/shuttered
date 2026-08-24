package io.fabianbuthere.shuttered.block;

import io.fabianbuthere.shuttered.Shuttered;
import io.fabianbuthere.shuttered.datagen.ModBlockStates;
import io.fabianbuthere.shuttered.datagen.ModItemModels;
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
    }
}
