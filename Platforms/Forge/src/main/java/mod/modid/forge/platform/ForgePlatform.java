package mod.modid.forge.platform;

import mod.modid.forge.platform.client.ForgeClientManager;
import mod.modid.forge.platform.configuration.ForgeConfigurationManager;
import mod.modid.forge.platform.creativetab.ForgeCreativeTabManager;
import mod.modid.forge.platform.distribution.ForgeDistributionManager;
import mod.modid.forge.platform.entity.ForgeEntityInformationManager;
import mod.modid.forge.platform.entity.ForgePlayerInventoryManager;
import mod.modid.forge.platform.fluid.ForgeFluidManager;
import mod.modid.forge.platform.item.DyeItemHelper;
import mod.modid.forge.platform.item.ForgeItemComparisonHelper;
import mod.modid.forge.platform.level.ForgeLevelBasedPropertyAccessor;
import mod.modid.forge.platform.network.ForgeNetworkChannelManager;
import mod.modid.forge.platform.plugin.ForgePluginManager;
import mod.modid.forge.platform.registry.ForgeRegistryManager;
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
import net.minecraftforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;

public class ForgePlatform implements IPlatformCore
{
    @Override
    public @NotNull IPlatformRegistryManager getPlatformRegistryManager()
    {
        return ForgeRegistryManager.getInstance();
    }

    @Override
    public @NotNull IEntityInformationManager getEntityInformationManager()
    {
        return ForgeEntityInformationManager.getInstance();
    }

    @Override
    public @NotNull IFluidManager getFluidManager()
    {
        return ForgeFluidManager.getInstance();
    }

    @Override
    public @NotNull IClientManager getClientManager()
    {
        return ForgeClientManager.getInstance();
    }

    @Override
    public @NotNull ILevelBasedPropertyAccessor getLevelBasedPropertyAccessor()
    {
        return ForgeLevelBasedPropertyAccessor.getInstance();
    }

    @Override
    public @NotNull IItemComparisonHelper getItemComparisonHelper()
    {
        return ForgeItemComparisonHelper.getInstance();
    }

    @Override
    public @NotNull IPlayerInventoryManager getPlayerInventoryManager()
    {
        return ForgePlayerInventoryManager.getInstance();
    }

    @Override
    public @NotNull IDistributionManager getDistributionManager()
    {
        return ForgeDistributionManager.getInstance();
    }

    @Override
    public @NotNull INetworkChannelManager getNetworkChannelManager()
    {
        return ForgeNetworkChannelManager.getInstance();
    }

    @Override
    public @NotNull IPlatformPluginManager getPlatformPluginManager()
    {
        return ForgePluginManager.getInstance();
    }

    @Override
    public @NotNull IDyeItemHelper getDyeItemHelper()
    {
        return DyeItemHelper.getInstance();
    }

    @Override
    public @NotNull IConfigurationManager getConfigurationManager()
    {
        return ForgeConfigurationManager.getInstance();
    }

    @Override
    public @NotNull MinecraftServer getCurrentServer()
    {
        return ServerLifecycleHooks.getCurrentServer();
    }

    @Override
    public @NotNull ICreativeTabManager getCreativeTabManager()
    {
        return ForgeCreativeTabManager.getInstance();
    }
}
