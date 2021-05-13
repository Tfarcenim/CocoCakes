package tfar.cococakes.datagen.tags;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.minecraftabnormals.neapolitan.core.registry.NeapolitanBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.cococakes.CocoCakes;
import tfar.cococakes.ModTags;
import tfar.cococakes.block.ModBlocks;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, CocoCakes.MODID, existingFileHelper);
    }

    static String modid = "peculiars";

    @Override
    protected void registerTags() {//2+7+2+5 = 16
        getOrCreateBuilder(ModTags.coco_cakes).add(Blocks.CAKE, ModBlocks.GOLDEN_CAKE.get())

                .addOptional(NeapolitanBlocks.ADZUKI_CAKE.get().getRegistryName())
                .addOptional(NeapolitanBlocks.CHOCOLATE_CAKE.get().getRegistryName())
                .addOptional(NeapolitanBlocks.VANILLA_CAKE.get().getRegistryName())
                .addOptional(NeapolitanBlocks.MINT_CAKE.get().getRegistryName())
                .addOptional(NeapolitanBlocks.CHOCOLATE_CAKE.get().getRegistryName())
                .addOptional(NeapolitanBlocks.STRAWBERRY_CAKE.get().getRegistryName())
                .addOptional(NeapolitanBlocks.BANANA_CAKE.get().getRegistryName())

                .addOptional(SeasonalsBlocks.PUMPKIN_CAKE.get().getRegistryName())
                .addOptional(SeasonalsBlocks.SWEET_BERRY_CAKE.get().getRegistryName())

                //.addOptional(PeculiarsBlocks.ALOE_CAKE.get().getRegistryName())
                //.addOptional(PeculiarsBlocks.PASSIONFRUIT_CAKE.get().getRegistryName())
                //.addOptional(PeculiarsBlocks.YUCCA_CAKE.get().getRegistryName())

                .addOptional(new ResourceLocation(modId, "aloe_cake"))
                .addOptional(new ResourceLocation(modId, "passionfruit_cake"))
                .addOptional(new ResourceLocation(modId, "yucca_cake"))
        ;
    }
}
