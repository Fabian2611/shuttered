package io.fabianbuthere.shuttered.datagen;

import io.fabianbuthere.shuttered.Shuttered;
import io.fabianbuthere.shuttered.block.ModBlocks;
import io.fabianbuthere.shuttered.block.custom.ShuttersBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStates extends BlockStateProvider {
    public ModBlockStates(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Shuttered.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerShutters("copper", ModBlocks.COPPER_SHUTTERS);
    }

    private void registerShutters(String variant, DeferredBlock<ShuttersBlock> block) {
        ModelFile closedModel = models().withExistingParent(variant + "_shutters", modLoc("block/shutters_template"))
                .texture("0", modLoc("block/" + variant + "_shutters"))
                .texture("particle", modLoc("block/" + variant + "_shutters"))
                .renderType("cutout");

        ModelFile openModel = models().withExistingParent(variant + "_shutters_open", modLoc("block/shutters_template_open"))
                .texture("0", modLoc("block/" + variant + "_shutters"))
                .texture("particle", modLoc("block/" + variant + "_shutters"))
                .renderType("cutout");

        getVariantBuilder(block.get()).forAllStates(state -> {
            Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            boolean isOpen = state.getValue(BlockStateProperties.OPEN);
            int yRot = (int) facing.toYRot();

            return ConfiguredModel.builder()
                    .modelFile(isOpen ? openModel : closedModel)
                    .rotationY(yRot + 180)
                    .build();
        });
    }
}
