package mod.modid.platforms.core.plugin;

import mod.modid.platforms.core.IPlatformCore;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.function.Function;

/**
 * The platform plugin manager which can load the plugins for the mod on a given platform.
 */
public interface IPlatformPluginManager
{

    /**
     * Gives access to the platform's plugin manager.
     *
     * @return The platform's plugin manager.
     */
    static IPlatformPluginManager getInstance() {
        return IPlatformCore.getInstance().getPlatformPluginManager();
    }

    /**
     * Loads the plugins of a given type, potentially marked with a given annotation type.
     *
     * @param annotationType The annotation type to look for.
     * @param instanceAnnotationType The annotation type that marks the instance of the plugin.
     * @param pluginSpecificationType The plugin specification interface type to look for.
     * @param idExtractor The function to extract the id from the plugin specification.
     * @param <A> The type of the annotation.
     * @param <I> The type of the instance annotation.
     * @param <T> The type of the interface.
     * @return All loaded plugins available.
     */
    <A, I extends Annotation, T> Collection<T> loadPlugins(
      final Class<A> annotationType,
      final Class<I> instanceAnnotationType,
      final Class<T> pluginSpecificationType,
      final Function<T, String> idExtractor
    );
}
