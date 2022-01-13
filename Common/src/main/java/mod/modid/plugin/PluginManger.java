package mod.modid.plugin;

import com.google.common.collect.ImmutableSet;
import mod.modid.api.plugin.Plugin;
import mod.modid.api.plugin.IPlugin;
import mod.modid.api.plugin.IPluginManager;
import mod.modid.platforms.core.plugin.IPlatformPluginManager;

import java.util.function.Consumer;

public final class PluginManger implements IPluginManager
{
    private static final PluginManger INSTANCE = new PluginManger();

    public static PluginManger getInstance()
    {
        return INSTANCE;
    }

    private ImmutableSet<IPlugin> plugins = ImmutableSet.of();

    private PluginManger()
    {
    }

    @Override
    public ImmutableSet<IPlugin> getPlugins()
    {
        return plugins;
    }

    @Override
    public void run(Consumer<IPlugin> callback) {
        getPlugins().forEach(callback);
    }

    public void detect() {
        this.plugins = ImmutableSet.copyOf(IPlatformPluginManager.getInstance().loadPlugins(
          Plugin.class,
          Plugin.Instance.class,
          IPlugin.class,
          IPlugin::getId
        ));
    }
}
