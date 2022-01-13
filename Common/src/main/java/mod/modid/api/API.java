package mod.modid.api;

import mod.modid.api.plugin.IPluginManager;
import mod.modid.plugin.PluginManger;
import org.jetbrains.annotations.NotNull;

public class API implements IAPI
{
    private static final API INSTANCE = new API();

    private API()
    {
    }

    public static API getInstance()
    {
        return INSTANCE;
    }

    @Override
    public @NotNull IPluginManager getPluginManager()
    {
        return PluginManger.getInstance();
    }
}
