package tfar.cococakes.datagen;


import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import tfar.cococakes.datagen.tags.ModBlockTagsProvider;
import tfar.cococakes.datagen.tags.ModItemTagsProvider;

public class DataGenerators {

    public static void setupDataGenerator(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        ExistingFileHelper helper = e.getExistingFileHelper();
        if (e.includeServer()) {
            BlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generator,helper);
            generator.addProvider(new ModBlockTagsProvider(generator,helper));
            generator.addProvider(new ModItemTagsProvider(generator,blockTagsProvider,helper));
        }
        if (e.includeClient()) {
        }
    }
}
