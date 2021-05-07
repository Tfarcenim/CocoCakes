package tfar.cococakes.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class GoldenCake extends CakeBlock {
    private final int FOOD_VALUE = 4;
    private final float FOOD_SATURATION = 0.2f;

    protected GoldenCake(AbstractBlock.Properties properties) {
        super(properties);
    }

    public ActionResultType onBlockActivated(final BlockState state, final World worldIn, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult p_225533_6_) {
        if (worldIn.isRemote) {
            final ItemStack itemstack = player.getHeldItem(handIn);
            if (this.eatCake(worldIn, pos, state, player) == ActionResultType.SUCCESS) {
                return ActionResultType.SUCCESS;
            }
            if (itemstack.isEmpty()) {
                return ActionResultType.CONSUME;
            }
        }
        return this.eatCake(worldIn, pos, state, player);
    }

    private ActionResultType eatCake(final IWorld world, final BlockPos blockPos, final BlockState state, final PlayerEntity player) {
        if (!player.canEat(false)) {
            return ActionResultType.PASS;
        }
        player.addStat(Stats.EAT_CAKE_SLICE);
        player.getFoodStats().addStats(FOOD_VALUE, FOOD_SATURATION);
        final int i = state.get(GoldenCake.BITES);
        if (i < 6) {
            world.setBlockState(blockPos, state.with(GoldenCake.BITES, i + 1), 3);
        } else {
            world.removeBlock(blockPos, false);
        }
        return ActionResultType.SUCCESS;
    }
}
