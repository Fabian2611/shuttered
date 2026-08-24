package io.fabianbuthere.shuttered.datagen;

import io.fabianbuthere.shuttered.Shuttered;
import io.fabianbuthere.shuttered.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModels extends ItemModelProvider {
    public ModItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Shuttered.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (String variant : ModItems.SHUTTER_VARIANTS) {
            withExistingParent(variant + "_shutters", modLoc("block/" + variant +"_shutters"));
        }
    }
}
