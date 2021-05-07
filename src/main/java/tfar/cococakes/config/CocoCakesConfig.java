package tfar.cococakes.config;

import net.minecraft.block.CakeBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;
import tfar.cococakes.CocoCakes;

@Mod.EventBusSubscriber(modid = CocoCakes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CocoCakesConfig
{
    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;
    private static boolean canHarvestCakes;
    private static int cakeMaxStackSize;
    
    public static void bakeConfig() {
        CocoCakesConfig.canHarvestCakes = CocoCakesConfig.CLIENT.canHarvestCakes.get();
        CocoCakesConfig.cakeMaxStackSize = CocoCakesConfig.CLIENT.cakeMaxStackSize.get();
    }
    
    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if (configEvent.getConfig().getSpec() == CocoCakesConfig.CLIENT_SPEC) {
            bakeConfig();
            onUpdateModConfig();
        }
    }
    
    public static boolean canRecollectCakes() {
        return CocoCakesConfig.canHarvestCakes;
    }
    
    public static int getCakeMaxStackSize() {
        return CocoCakesConfig.cakeMaxStackSize;
    }
    
    static {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static void onUpdateModConfig() {
        final int cakeMaxStackSize = getCakeMaxStackSize();
        for (Item item : Registry.ITEM) {
            if (item instanceof BlockItem && ((BlockItem)item).getBlock() instanceof CakeBlock) {
                item.maxStackSize = cakeMaxStackSize;
            }
        }
    }
}
