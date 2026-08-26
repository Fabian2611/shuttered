package io.fabianbuthere.shuttered.datagen;

import io.fabianbuthere.shuttered.Shuttered;
import io.fabianbuthere.shuttered.block.ModBlocks;
import io.fabianbuthere.shuttered.block.custom.ShuttersBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTags extends BlockTagsProvider {
    public static final TagKey<Block> SHUTTERS = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(Shuttered.MODID, "shutters")
    );

    public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Shuttered.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        for (DeferredBlock<ShuttersBlock> block : ModBlocks.SHUTTERS) {
            tag(BlockTags.MINEABLE_WITH_AXE).add(block.get());
            tag(SHUTTERS).add(block.get());
        }
    }
}
