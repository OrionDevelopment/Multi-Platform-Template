package mod.modid.forge;

import mod.modid.Mod;
import mod.modid.forge.platform.ForgePlatform;
import mod.modid.platforms.core.IPlatformCore;
import mod.modid.platforms.core.util.constants.Constants;

@net.minecraftforge.fml.common.Mod(Constants.MOD_ID)
public class ForgeChiselsAndBits
{
	private static Mod           instance;
    private static ForgePlatform platform;

	public ForgeChiselsAndBits()
	{
        platform = new ForgePlatform();
        IPlatformCore.Holder.setInstance(platform);

	    instance = new Mod();
	}

    public static Mod getInstance()
    {
        return instance;
    }
}
