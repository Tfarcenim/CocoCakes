package tfar.cococakes.item;

import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import tfar.cococakes.CocoCakes;
import net.minecraft.item.Item;

public enum ModItems {
    COCOA_POWDER(new Item(new Item.Properties().group(ModItemGroup.MAIN)), "cocoa_powder"),
    CHOCOLATE_MILK(new MilkBucketItem(new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ModItemGroup.MAIN)), "choco_milk_bucket");

    private final Item item;

    ModItems(final Item item, final String name) {
        this.item = item.setRegistryName(CocoCakes.location(name));
    }

    public static Item[] getAll() {
        final ModItems[] values = values();
        final Item[] items = new Item[values.length];
        for (int i = 0; i < values.length; ++i) {
            items[i] = values[i].item;
        }
        return items;
    }

    public Item get() {
        return this.item;
    }
}
