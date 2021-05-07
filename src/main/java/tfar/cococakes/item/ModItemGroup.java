

package tfar.cococakes.item;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import tfar.cococakes.CocoCakes;

import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
public class ModItemGroup extends ItemGroup {
    public static final ItemGroup MAIN;
    private final Supplier<ItemStack> iconSupplier;

    public ModItemGroup(final String label, final Supplier<ItemStack> iconSupplier) {
        super(label);
        this.iconSupplier = iconSupplier;
    }

    public ItemStack createIcon() {
        return this.iconSupplier.get();
    }

    static {
        MAIN = new ModItemGroup(CocoCakes.MODID, () -> new ItemStack(Items.CAKE));
    }
}
