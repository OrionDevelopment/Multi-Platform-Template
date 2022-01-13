package mod.modid.api.plugin;

import com.google.common.collect.ImmutableSet;
import mod.modid.api.IAPI;

import java.util.function.Consumer;

/**
 * The manager for plugins.
 */
public interface IPluginManager
{

    /**
     * The instance of the plugin manager.
     *
     * @return The plugin manager.
     */
    static IPluginManager getInstance() {
        return IAPI.getInstance().getPluginManager();
    }

    /**
     * Gets the plugins.
     *
     * @return An immutable set with the plugins.
     */
    ImmutableSet<IPlugin> getPlugins();

    /**
     * Runs a specific task on all available plugins.
     *
     * @param callback The task to run for each plugin.
     */
    void run(final Consumer<IPlugin> callback);
}
