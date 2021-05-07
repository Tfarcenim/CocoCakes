package tfar.cococakes;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import tfar.cococakes.block.ModBlocks;
import tfar.cococakes.item.ModItemGroup;
import tfar.cococakes.item.ModItems;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = CocoCakes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.getAll());
    }

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(ModItems.getAll());
        for (final Block block : ModBlocks.getAll()) {
            final Item.Properties properties = new Item.Properties().group(ModItemGroup.MAIN);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
            registry.register(blockItem);
        }
    }

    @SubscribeEvent
    public static void registerModifierSerializers(final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().register(SilkTouchCakeModifier.getNewSerializer());
    }
}
