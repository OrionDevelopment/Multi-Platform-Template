package mod.modid.api;

import mod.modid.api.addons.IChiselsAndBitsAddon;
import mod.modid.api.plugin.IPluginManager;
import org.jetbrains.annotations.NotNull;

/**
 * Do not implement, is passed to your {@link IChiselsAndBitsAddon},
 * and can be accessed via its {@link #getInstance()}-method.
 */
public interface IAPI
{
    /**
     * Gives access to the api instance.
     *
     * @return The api.
     */
    static IAPI getInstance()
    {
        return Holder.getInstance();
    }

    /**
     * Gives access to the plugin manager that is used to process mod plugins
     * @return The plugin manager
     */
    @NotNull
    IPluginManager getPluginManager();

    class Holder {
        private static IAPI apiInstance;

        public static IAPI getInstance()
        {
            return apiInstance;
        }

        public static void setInstance(final IAPI instance)
        {
            if (apiInstance != null)
                throw new IllegalStateException("Can not setup API twice!");

            apiInstance = instance;
        }
    }
}
