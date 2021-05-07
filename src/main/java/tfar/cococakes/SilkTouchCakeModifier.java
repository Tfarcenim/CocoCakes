package tfar.cococakes;

import com.google.gson.JsonObject;
import tfar.cococakes.config.CocoCakesConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import java.util.List;

public class SilkTouchCakeModifier extends LootModifier {
    public SilkTouchCakeModifier(final ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    public List<ItemStack> doApply(final List<ItemStack> generatedLoot, final LootContext context) {
        final BlockState state = context.get(LootParameters.BLOCK_STATE);
        if (state != null) {
            final Item selfDrop = state.getBlock().asItem();
            final ItemStack cakeLoot = getItemFromLoot(generatedLoot, selfDrop);
            if (state.get(CakeBlock.BITES) > 0) {
                generatedLoot.remove(cakeLoot);
            } else if (CocoCakesConfig.canRecollectCakes()) {
                if (cakeLoot.isEmpty()) {
                    generatedLoot.add(new ItemStack(selfDrop));
                }
            } else if (!cakeLoot.isEmpty()) {
                generatedLoot.remove(cakeLoot);
            }
        }
        return generatedLoot;
    }

    private static ItemStack getItemFromLoot(final List<ItemStack> loot, final Item item) {
        for (final ItemStack itemStack : loot) {
            if (itemStack.getItem() == item) {
                return itemStack;
            }
        }
        return ItemStack.EMPTY;
    }

    public static GlobalLootModifierSerializer<SilkTouchCakeModifier> getNewSerializer() {
        return new Serializer().setRegistryName(CocoCakes.location("silk_touch_cake"));
    }

    static class Serializer extends GlobalLootModifierSerializer<SilkTouchCakeModifier> {
        public SilkTouchCakeModifier read(final ResourceLocation name, final JsonObject object, final ILootCondition[] conditionsIn) {
            return new SilkTouchCakeModifier(conditionsIn);
        }

        @Override
        public JsonObject write(SilkTouchCakeModifier instance) {
            return new JsonObject();//todo is this correct?
        }
    }
}
