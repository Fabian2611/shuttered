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

    public static final DeferredBlock<ShuttersBlock> ACACIA_SHUTTERS =
            BLOCKS.registerBlock("acacia_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS));

    public static final DeferredBlock<ShuttersBlock> DARK_OAK_SHUTTERS =
            BLOCKS.registerBlock("dark_oak_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS));

    public static final DeferredBlock<ShuttersBlock> IRON_SHUTTERS =
            BLOCKS.registerBlock("iron_shutters", ShuttersBlock::createIronType, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

    public static final DeferredBlock<ShuttersBlock> SPRUCE_SHUTTERS =
            BLOCKS.registerBlock("spruce_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS));

    public static final DeferredBlock<ShuttersBlock> WARPED_SHUTTERS =
            BLOCKS.registerBlock("warped_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS));

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
