package mod.modid.fabric.platform.registry;

import mod.modid.fabric.platform.registry.delegates.FabricIdMapperPlatformDelegate;
import mod.modid.fabric.platform.registry.delegates.FabricRegistryPlatformDelegate;
import mod.modid.fabric.platform.registry.registar.FabricRegistrarManager;
import mod.modid.platforms.core.registries.IPlatformRegistry;
import mod.modid.platforms.core.registries.IPlatformRegistryManager;
import mod.modid.platforms.core.registries.ISizedIdMap;
import mod.modid.platforms.core.registries.deferred.IRegistrarManager;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;

public final class FabricRegistryManager implements IPlatformRegistryManager
{
    private static final FabricRegistryManager INSTANCE = new FabricRegistryManager();

    public static FabricRegistryManager getInstance()
    {
        return INSTANCE;
    }

    @Override
    public IRegistrarManager getRegistrarManager()
    {
        return FabricRegistrarManager.getInstance();
    }

    @Override
    public IPlatformRegistry<Item> getItemRegistry()
    {
        return new FabricRegistryPlatformDelegate<>(Registry.ITEM);
    }

    @Override
    public IPlatformRegistry<Block> getBlockRegistry()
    {
        return new FabricRegistryPlatformDelegate<>(Registry.BLOCK);
    }

    @Override
    public ISizedIdMap<BlockState> getBlockStateIdMap()
    {
        return new FabricIdMapperPlatformDelegate<>(Block.BLOCK_STATE_REGISTRY);
    }

    @Override
    public IPlatformRegistry<Fluid> getFluids()
    {
        return new FabricRegistryPlatformDelegate<>(Registry.FLUID);
    }

    private FabricRegistryManager()
    {
    }
}
