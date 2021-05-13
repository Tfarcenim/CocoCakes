package tfar.cococakes.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
    public final ForgeConfigSpec.BooleanValue canHarvestCakes;
    public final ForgeConfigSpec.IntValue cakeMaxStackSize;
    
    public ServerConfig(final ForgeConfigSpec.Builder builder) {
        this.canHarvestCakes = builder.comment("Can cake blocks be harvested when broken?").translation("cococakes.config.canRecollectCakes").define("canHarvestCakes", true);
        this.cakeMaxStackSize = builder.comment("Maximum size of cake item stack").translation("cococakes.config.cakeMaxStackSize").defineInRange("cakeMaxStackSize", 1, 0, 64);
        builder.build();
    }
}
