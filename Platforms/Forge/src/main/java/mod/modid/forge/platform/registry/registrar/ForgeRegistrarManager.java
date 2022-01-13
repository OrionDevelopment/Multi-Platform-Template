package mod.modid.forge.platform.registry.registrar;

import mod.modid.forge.platform.registry.registrar.delegates.ForgeDeferredRegisterPlatformDelegate;
import mod.modid.platforms.core.registries.ICustomRegistry;
import mod.modid.platforms.core.registries.ICustomRegistryEntry;
import mod.modid.platforms.core.registries.deferred.ICustomRegistrar;
import mod.modid.platforms.core.registries.deferred.IRegistrar;
import mod.modid.platforms.core.registries.deferred.IRegistrarManager;
import mod.modid.platforms.core.registries.deferred.impl.custom.CustomRegistryManager;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistryEntry;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ForgeRegistrarManager implements IRegistrarManager
{
    private static final ForgeRegistrarManager INSTANCE = new ForgeRegistrarManager();

    public static ForgeRegistrarManager getInstance()
    {
        return INSTANCE;
    }

    private ForgeRegistrarManager()
    {
    }

    @Override
    public <T extends ICustomRegistryEntry, R extends T> ICustomRegistrar<R> createCustomRegistrar(
      final Class<T> typeClass, final String modId)
    {
        return CustomRegistryManager.getInstance().createNewRegistrar(typeClass, modId);
    }

    @Override
    public <T, R extends T> IRegistrar<R> createRegistrar(final Class<T> typeClass, final String modId)
    {
        final DeferredRegister register = DeferredRegister.create((Class<IForgeRegistryEntry>)typeClass, modId);

        register.register(FMLJavaModLoadingContext.get().getModEventBus());

        return new ForgeDeferredRegisterPlatformDelegate(
          register
        );
    }

    @Override
    public <T extends ICustomRegistryEntry> ICustomRegistry.Builder<T> simpleBuilderFor()
    {
        return CustomRegistryManager.getInstance().createNewSimpleBuilder();
    }
}
