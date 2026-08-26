package io.fabianbuthere.shuttered.datagen;

import io.fabianbuthere.shuttered.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        shuttersRecipe(recipeOutput, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_SHUTTERS);
        shuttersRecipe(recipeOutput, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_SHUTTERS);
        shuttersRecipe(recipeOutput, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_SHUTTERS);
        shuttersRecipe(recipeOutput, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_SHUTTERS);
        shuttersRecipe(recipeOutput, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_SHUTTERS);
        shuttersRecipe(recipeOutput, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_SHUTTERS);
        shuttersRecipe(recipeOutput, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_SHUTTERS);
        shuttersRecipe(recipeOutput, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_SHUTTERS);
        shuttersRecipe(recipeOutput, Blocks.OAK_PLANKS, ModBlocks.OAK_SHUTTERS);
        shuttersRecipe(recipeOutput, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_SHUTTERS);
        shuttersRecipe(recipeOutput, Blocks.WARPED_PLANKS, ModBlocks.WARPED_SHUTTERS);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_SHUTTERS, 4)
                .define('#', Items.IRON_INGOT)
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .group("shutters")
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COPPER_SHUTTERS, 4)
                .define('#', Items.COPPER_INGOT)
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .group("shutters")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(recipeOutput);
    }

    private void shuttersRecipe(@NotNull RecipeOutput recipeOutput, ItemLike item, ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 4)
                .define('#', item)
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .group("shutters")
                .unlockedBy("has_any_planks", has(item))
                .save(recipeOutput);
    }
}
