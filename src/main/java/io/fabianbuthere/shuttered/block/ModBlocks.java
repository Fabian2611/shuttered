package io.fabianbuthere.shuttered.block;

import io.fabianbuthere.shuttered.Shuttered;
import io.fabianbuthere.shuttered.block.custom.ShuttersBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Shuttered.MODID);

    public static final DeferredBlock<ShuttersBlock> COPPER_SHUTTERS =
            BLOCKS.registerBlock("copper_shutters", ShuttersBlock::createIronType, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK));

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
