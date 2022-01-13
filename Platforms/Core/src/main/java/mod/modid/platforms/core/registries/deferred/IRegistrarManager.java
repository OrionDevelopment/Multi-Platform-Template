package mod.modid.platforms.core.registries.deferred;

import mod.modid.platforms.core.registries.ICustomRegistry;
import mod.modid.platforms.core.registries.ICustomRegistryEntry;
import mod.modid.platforms.core.registries.IPlatformRegistryManager;

/**
 * Manages the deferred registration system for the underlying platform.
 */
public interface IRegistrarManager
{
    /**
     * Gives access to the deferred registrar manager.
     *
     * @return The deferred registrar manager.
     */
    static IRegistrarManager getInstance() {
        return IPlatformRegistryManager.getInstance().getRegistrarManager();
    }

    /**
     * Returns a new registrar for the type given in the namespace of the mod id.
     *
     * @param typeClass The type of the registry for the registrar.
     * @param modId The mod if.
     * @param <T> The type in the registry.
     * @return The registrar for a registry of the given type in the given namespace.
     */
    <T extends ICustomRegistryEntry, R extends T> ICustomRegistrar<R> createCustomRegistrar(Class<T> typeClass, String modId);

    /**
     * Returns a new registrar for the type given in the namespace of the mod id.
     *
     * @param typeClass The type of the registry for the registrar.
     * @param modId The mod if.
     * @param <T> The type in the registry.
     * @return The registrar for a registry of the given type in the given namespace.
     */
    <T, R extends T> IRegistrar<R> createRegistrar(Class<T> typeClass, String modId);

    /**
     * Creates a new registry builder for the given registry type.
     *
     * @param <T> The type contained in the registry.
     * @return The registry builder.
     */
    <T extends ICustomRegistryEntry> ICustomRegistry.Builder<T> simpleBuilderFor();
}
