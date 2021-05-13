package tfar.cococakes;

import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

public class ModTags {

    public static final ITag.INamedTag<Block> coco_cakes = BlockTags.makeWrapperTag(new ResourceLocation(CocoCakes.MODID,"cakes").toString());

}
