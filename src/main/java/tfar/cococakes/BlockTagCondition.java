package tfar.cococakes;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.loot.ILootSerializer;
import net.minecraft.loot.LootConditionType;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;

public class BlockTagCondition implements ILootCondition {
    private final ITag.INamedTag<Block> blockTag;

    public BlockTagCondition(final ITag.INamedTag<Block> blockTag) {
        this.blockTag = blockTag;
    }

    public boolean test(final LootContext lootContext) {
        final BlockState state = lootContext.get(LootParameters.BLOCK_STATE);
        return state != null && this.blockTag.contains(state.getBlock());
    }

    @Override
    public LootConditionType getConditionType() {
        return CocoCakes.TYPE;
    }

    public static class Serializer implements ILootSerializer<BlockTagCondition> {
        public Serializer() {}

        public void serialize(final JsonObject json, final BlockTagCondition value, final JsonSerializationContext context) {
            json.addProperty("tag", value.blockTag.getName().toString());
        }

        public BlockTagCondition deserialize(final JsonObject json, final JsonDeserializationContext context) {
            final ResourceLocation tagName = new ResourceLocation(JSONUtils.getString(json, "tag"));
            return new BlockTagCondition(BlockTags.makeWrapperTag(tagName.toString()));
        }
    }
}
