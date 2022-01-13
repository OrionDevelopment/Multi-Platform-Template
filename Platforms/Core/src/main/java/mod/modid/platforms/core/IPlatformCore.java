package mod.modid.platforms.core;

import mod.modid.platforms.core.blockstate.ILevelBasedPropertyAccessor;
import mod.modid.platforms.core.chiseling.eligibility.IPlatformEligibilityOptions;
import mod.modid.platforms.core.client.IClientManager;
import mod.modid.platforms.core.config.IConfigurationManager;
import mod.modid.platforms.core.creativetab.ICreativeTabManager;
import mod.modid.platforms.core.dist.IDistributionManager;
import mod.modid.platforms.core.entity.IEntityInformationManager;
import mod.modid.platforms.core.entity.IPlayerInventoryManager;
import mod.modid.platforms.core.fluid.IFluidManager;
import mod.modid.platforms.core.inventory.bit.IAdaptingBitInventoryManager;
import mod.modid.platforms.core.item.IDyeItemHelper;
import mod.modid.platforms.core.item.IItemComparisonHelper;
import mod.modid.platforms.core.network.INetworkChannelManager;
import mod.modid.platforms.core.plugin.IPlatformPluginManager;
import mod.modid.platforms.core.registries.IPlatformRegistryManager;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

/**
 * API Surface of a given game platform that is required to run mod.
 * Each game platform, like forge or fabric, has to provide this logic, outside
 * of Minecraft.
 *
 * Examples are registry access and systems to interact with the world.
 */
public interface IPlatformCore
{
    /**
     * Gives access to the api instance.
     *
     * @return The api.
     */
    static IPlatformCore getInstance()
    {
        return Holder.getInstance();
    }

    /**
     * Gives access to the current platform's registry.
     *
     * @return The registry manager for the current platform.
     */
    @NotNull
    IPlatformRegistryManager getPlatformRegistryManager();

    /**
     * Gives access to the current platform's way of processing entity information.
     *
     * @return The entity information manager.
     */
    @NotNull
    IEntityInformationManager getEntityInformationManager();

    /**
     * Gives access to the fluid manager of the current platform.
     *
     * @return The fluid manager of the current platform.
     */
    @NotNull
    IFluidManager getFluidManager();

    /**
     * The client manager for this platform.
     * Invoking this method on the server side, will throw an exception!
     *
     * @return The client manager.
     */
    @NotNull
    IClientManager getClientManager();

    /**
     * Gives access to level based property accessors.
     *
     * @return The accessor for level based properties.
     */
    @NotNull
    ILevelBasedPropertyAccessor getLevelBasedPropertyAccessor();

    /**
     * The item comparison helper of the platform at large.
     * Some platforms extend the functionality of itemstacks beyond item, meta and nbt.
     * And sometimes these values have to be taken into account while comparing itemstacks.
     *
     * @return The item comparison helper.
     */
    @NotNull
    IItemComparisonHelper getItemComparisonHelper();

    /**
     * Gives access to the player inventory manager.
     *
     * @return The player inventory manager.
     */
    @NotNull
    IPlayerInventoryManager getPlayerInventoryManager();

    /**
     * Gives access to the distribution manager.
     *
     * @return The distribution manager.
     */
    @NotNull
    IDistributionManager getDistributionManager();

    /**
     * Gives access to the network manager.
     *
     * @return The network manager.
     */
    @NotNull
    INetworkChannelManager getNetworkChannelManager();

    /**
     * Gives access to the platform's plugin manager.
     *
     * @return The platform's plugin manager.
     */
    @NotNull
    IPlatformPluginManager getPlatformPluginManager();

    /**
     * Gives access to the dye item helper on the platform.
     *
     * @return The dye item helper.
     */
    @NotNull
    IDyeItemHelper getDyeItemHelper();

    /**
     * The configuration manager for the current platform.
     *
     * @return The configuration manager.
     */
    @NotNull
    IConfigurationManager getConfigurationManager();

    /**
     * Gives access to the current server platform.
     *
     * @return The current server running.
     */
    @NotNull
    MinecraftServer getCurrentServer();

    /**
     * The manager for handling creative tabs on the platform.
     *
     * @return The platforms creative tab manager.
     */
    @NotNull
    ICreativeTabManager getCreativeTabManager();

    class Holder {
        private static IPlatformCore apiInstance;

        public static IPlatformCore getInstance()
        {
            return apiInstance;
        }

        public static void setInstance(final IPlatformCore instance)
        {
            if (apiInstance != null)
                throw new IllegalStateException("Can not setup API twice!");

            apiInstance = instance;
        }
    }
}
