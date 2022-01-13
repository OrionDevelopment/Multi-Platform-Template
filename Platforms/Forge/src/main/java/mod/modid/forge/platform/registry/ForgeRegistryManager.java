package mod.modid.forge.platform.registry;

import mod.modid.forge.platform.registry.delegates.ForgeIdMapperPlatformDelegate;
import mod.modid.forge.platform.registry.delegates.ForgeRegistryPlatformDelegate;
import mod.modid.forge.platform.registry.registrar.ForgeRegistrarManager;
import mod.modid.platforms.core.registries.IPlatformRegistry;
import mod.modid.platforms.core.registries.IPlatformRegistryManager;
import mod.modid.platforms.core.registries.ISizedIdMap;
import mod.modid.platforms.core.registries.deferred.IRegistrarManager;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.GameData;

public class ForgeRegistryManager implements IPlatformRegistryManager
{
    private static final ForgeRegistryManager INSTANCE = new ForgeRegistryManager();

    public static ForgeRegistryManager getInstance()
    {
        return INSTANCE;
    }

    private final ForgeRegistryPlatformDelegate<Item>  itemRegistry  = new ForgeRegistryPlatformDelegate<>(ForgeRegistries.ITEMS);
    private final ForgeRegistryPlatformDelegate<Block>      blockRegistry      = new ForgeRegistryPlatformDelegate<>(ForgeRegistries.BLOCKS);
    private final ForgeIdMapperPlatformDelegate<BlockState> blockStateIdMapper = new ForgeIdMapperPlatformDelegate<>(GameData.getBlockStateIDMap());
    private final ForgeRegistryPlatformDelegate<Fluid>      fluidRegistry      = new ForgeRegistryPlatformDelegate<>(ForgeRegistries.FLUIDS);

    private ForgeRegistryManager()
    {
    }

    @Override
    public IRegistrarManager getRegistrarManager()
    {
        return ForgeRegistrarManager.getInstance();
    }

    @Override
    public IPlatformRegistry<Item> getItemRegistry()
    {
        return itemRegistry;
    }

    @Override
    public IPlatformRegistry<Block> getBlockRegistry()
    {
        return blockRegistry;
    }

    @Override
    public ISizedIdMap<BlockState> getBlockStateIdMap()
    {
        return blockStateIdMapper;
    }

    @Override
    public IPlatformRegistry<Fluid> getFluids()
    {
        return fluidRegistry;
    }
}
