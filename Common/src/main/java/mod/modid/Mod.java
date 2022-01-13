package mod.modid;

import mod.modid.api.API;
import mod.modid.api.IAPI;
import mod.modid.api.plugin.IPlugin;
import mod.modid.network.NetworkChannel;
import mod.modid.platforms.core.util.constants.Constants;
import mod.modid.plugin.PluginManger;
import mod.modid.utils.LanguageHandler;

public class Mod
{
	private static Mod            instance;
	private final  NetworkChannel networkChannel = new NetworkChannel(Constants.MOD_ID);


	public Mod()
	{
	    instance = this;
        LanguageHandler.loadLangPath("assets/modid/lang/%s.json");

        IAPI.Holder.setInstance(API.getInstance());

        networkChannel.registerCommonMessages();

        PluginManger.getInstance().detect();
        PluginManger.getInstance().run(IPlugin::onConstruction);
	}

	public static Mod getInstance()
	{
		return instance;
	}

    public NetworkChannel getNetworkChannel() {
	    return networkChannel;
    }

    public void onCommonConstruction() {
        PluginManger.getInstance().run(IPlugin::onCommonSetup);
    }
}
