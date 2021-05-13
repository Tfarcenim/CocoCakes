package tfar.cococakes.datagen.tags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.cococakes.CocoCakes;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {


    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, CocoCakes.MODID, existingFileHelper);
    }

    @Override
    protected void registerTags() {

    }
}
