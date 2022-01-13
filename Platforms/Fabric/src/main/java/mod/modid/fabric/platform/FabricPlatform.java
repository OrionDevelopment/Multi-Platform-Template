package mod.modid.fabric.platform;

import mod.modid.fabric.platform.client.FabricClientManager;
import mod.modid.fabric.platform.configuration.FabricConfigurationManager;
import mod.modid.fabric.platform.creativetab.FabricCreativeTabManager;
import mod.modid.fabric.platform.dist.FabricDistributionManager;
import mod.modid.fabric.platform.entity.FabricEntityInformationManager;
import mod.modid.fabric.platform.fluid.FabricFluidManager;
import mod.modid.fabric.platform.inventory.FabricPlayerInventoryManager;
import mod.modid.fabric.platform.item.FabricDyeItemHelper;
import mod.modid.fabric.platform.item.FabricItemComparisonHelper;
import mod.modid.fabric.platform.level.FabricLevelBasedPropertyAccessor;
import mod.modid.fabric.platform.network.FabricNetworkChannelManager;
import mod.modid.fabric.platform.plugin.FabricPluginManager;
import mod.modid.fabric.platform.registry.FabricRegistryManager;
import mod.modid.fabric.platform.server.FabricServerLifecycleManager;
import mod.modid.platforms.core.IPlatformCore;
import mod.modid.platforms.core.blockstate.ILevelBasedPropertyAccessor;
import mod.modid.platforms.core.client.IClientManager;
import mod.modid.platforms.core.config.IConfigurationManager;
import mod.modid.platforms.core.creativetab.ICreativeTabManager;
import mod.modid.platforms.core.dist.IDistributionManager;
import mod.modid.platforms.core.entity.IEntityInformationManager;
import mod.modid.platforms.core.entity.IPlayerInventoryManager;
import mod.modid.platforms.core.fluid.IFluidManager;
import mod.modid.platforms.core.item.IDyeItemHelper;
import mod.modid.platforms.core.item.IItemComparisonHelper;
import mod.modid.platforms.core.network.INetworkChannelManager;
import mod.modid.platforms.core.plugin.IPlatformPluginManager;
import mod.modid.platforms.core.registries.IPlatformRegistryManager;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

public final class FabricPlatform implements IPlatformCore
{
    private static final FabricPlatform INSTANCE = new FabricPlatform();

    public static FabricPlatform getInstance()
    {
        return INSTANCE;
    }

    private FabricPlatform()
    {
    }

    @Override
    public @NotNull IPlatformRegistryManager getPlatformRegistryManager()
    {
        return FabricRegistryManager.getInstance();
    }

    @Override
    public @NotNull IEntityInformationManager getEntityInformationManager()
    {
        return FabricEntityInformationManager.getInstance();
    }

    @Override
    public @NotNull IFluidManager getFluidManager()
    {
        return FabricFluidManager.getInstance();
    }

    @Override
    public @NotNull IClientManager getClientManager()
    {
        return FabricClientManager.getInstance();
    }

    @Override
    public @NotNull ILevelBasedPropertyAccessor getLevelBasedPropertyAccessor()
    {
        return FabricLevelBasedPropertyAccessor.getInstance();
    }

    @Override
    public @NotNull IItemComparisonHelper getItemComparisonHelper()
    {
        return FabricItemComparisonHelper.getInstance();
    }

    @Override
    public @NotNull IPlayerInventoryManager getPlayerInventoryManager()
    {
        return FabricPlayerInventoryManager.getInstance();
    }

    @Override
    public @NotNull IDistributionManager getDistributionManager()
    {
        return FabricDistributionManager.getInstance();
    }

    @Override
    public @NotNull INetworkChannelManager getNetworkChannelManager()
    {
        return FabricNetworkChannelManager.getInstance();
    }

    @Override
    public @NotNull IPlatformPluginManager getPlatformPluginManager()
    {
        return FabricPluginManager.getInstance();
    }

    @Override
    public @NotNull IDyeItemHelper getDyeItemHelper()
    {
        return FabricDyeItemHelper.getInstance();
    }

    @Override
    public @NotNull IConfigurationManager getConfigurationManager()
    {
        return FabricConfigurationManager.getInstance();
    }

    @Override
    public @NotNull MinecraftServer getCurrentServer()
    {
        return FabricServerLifecycleManager.getInstance().getServer();
    }

    @Override
    public @NotNull ICreativeTabManager getCreativeTabManager()
    {
        return FabricCreativeTabManager.getInstance();
    }
}
