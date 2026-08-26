package io.fabianbuthere.shuttered.block;

import io.fabianbuthere.shuttered.Shuttered;
import io.fabianbuthere.shuttered.block.custom.ShuttersBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Shuttered.MODID);

    public static final DeferredBlock<ShuttersBlock> COPPER_SHUTTERS =
            BLOCKS.registerBlock("copper_shutters", ShuttersBlock::createIronType, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK));

    public static final DeferredBlock<ShuttersBlock> ACACIA_SHUTTERS =
            BLOCKS.registerBlock("acacia_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS));

    public static final DeferredBlock<ShuttersBlock> JUNGLE_SHUTTERS =
            BLOCKS.registerBlock("jungle_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS));

    public static final DeferredBlock<ShuttersBlock> DARK_OAK_SHUTTERS =
            BLOCKS.registerBlock("dark_oak_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS));

    public static final DeferredBlock<ShuttersBlock> IRON_SHUTTERS =
            BLOCKS.registerBlock("iron_shutters", ShuttersBlock::createIronType, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

    public static final DeferredBlock<ShuttersBlock> SPRUCE_SHUTTERS =
            BLOCKS.registerBlock("spruce_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS));

    public static final DeferredBlock<ShuttersBlock> WARPED_SHUTTERS =
            BLOCKS.registerBlock("warped_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS));

    public static final DeferredBlock<ShuttersBlock> MANGROVE_SHUTTERS =
            BLOCKS.registerBlock("mangrove_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS));

    public static final DeferredBlock<ShuttersBlock> OAK_SHUTTERS =
            BLOCKS.registerBlock("oak_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));

    public static final DeferredBlock<ShuttersBlock> CRIMSON_SHUTTERS =
            BLOCKS.registerBlock("crimson_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS));

    public static final DeferredBlock<ShuttersBlock> BAMBOO_SHUTTERS =
            BLOCKS.registerBlock("bamboo_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS));

    public static final DeferredBlock<ShuttersBlock> BIRCH_SHUTTERS =
            BLOCKS.registerBlock("birch_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS));

    public static final DeferredBlock<ShuttersBlock> CHERRY_SHUTTERS =
            BLOCKS.registerBlock("cherry_shutters", ShuttersBlock::create, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS));

    public static final Set<DeferredBlock<ShuttersBlock>> SHUTTERS = Set.of(
            COPPER_SHUTTERS, ACACIA_SHUTTERS, JUNGLE_SHUTTERS, DARK_OAK_SHUTTERS, IRON_SHUTTERS, SPRUCE_SHUTTERS,
            WARPED_SHUTTERS, MANGROVE_SHUTTERS, OAK_SHUTTERS, CRIMSON_SHUTTERS, BAMBOO_SHUTTERS, BIRCH_SHUTTERS, CHERRY_SHUTTERS
    );

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
