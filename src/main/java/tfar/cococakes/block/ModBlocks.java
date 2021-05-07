package tfar.cococakes.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import tfar.cococakes.CocoCakes;

public enum ModBlocks {
    CHOCOLATE_CAKE(new CakeBlock(AbstractBlock.Properties.create(Material.CAKE).hardnessAndResistance(.5f).sound(SoundType.CLOTH)),"choco_cake"),
    GOLDEN_CAKE(new GoldenCake(AbstractBlock.Properties.create(Material.CAKE, MaterialColor.GOLD).hardnessAndResistance(.5f).sound(SoundType.CLOTH)), "golden_cake");

    private final Block block;

    ModBlocks(final Block block, final String name) {
        this.block = block.setRegistryName(CocoCakes.location(name));
    }

    public static Block[] getAll() {
        final ModBlocks[] values = values();
        final Block[] blocks = new Block[values.length];
        for (int i = 0; i < values.length; ++i) {
            blocks[i] = values[i].block;
        }
        return blocks;
    }

    public Block get() {
        return this.block;
    }
}
