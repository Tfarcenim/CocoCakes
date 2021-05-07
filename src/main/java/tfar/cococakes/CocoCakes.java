package tfar.cococakes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ILootSerializer;
import net.minecraft.loot.LootConditionType;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tfar.cococakes.config.CocoCakesConfig;

@Mod(CocoCakes.MODID)
public class CocoCakes {

    public static LootConditionType TYPE = register("cococakes:block_tag",new BlockTagCondition.Serializer());

    public static final String MODID = "cococakes";

    public CocoCakes() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.addListener(this::onBlockRightClick);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CocoCakesConfig.CLIENT_SPEC);
    }
    
    private void setup(final FMLCommonSetupEvent event) {
    }
    
    public static ResourceLocation location(final String path) {
        return new ResourceLocation(CocoCakes.MODID, path);
    }

    public void onBlockRightClick(final PlayerInteractEvent.RightClickBlock event) {
        final World world = event.getWorld();
        final BlockPos pos = event.getPos();
        final PlayerEntity player = event.getPlayer();
        final BlockState state = world.getBlockState(pos);
        final Block block = state.getBlock();
        final boolean isBlockCake = block instanceof CakeBlock;
        if (!isBlockCake || !player.canEat(false)) {
            return;
        }
        final ItemStack stack = block.getPickBlock(state, null, world, pos, player);
        //player.addItemParticles(stack, 2);
        final SoundEvent eatSound = player.getEatSound(stack);
        player.playSound(eatSound, 0.15f + 0.05f * world.rand.nextInt(2), (world.rand.nextFloat() - world.rand.nextFloat()) * 0.04f + 0.25f);
    }

    private static LootConditionType register(String registryName, ILootSerializer<? extends ILootCondition> serializer) {
        return Registry.register(Registry.LOOT_CONDITION_TYPE, new ResourceLocation(registryName), new LootConditionType(serializer));
    }

}
