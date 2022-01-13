package mod.modid.api.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation which marks a given class as being a mod plugin.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Plugin
{
    /**
     * Used to on a static field of a class annotated with {@link Plugin} to represent the field is an instance of an {@link Plugin}. This instance
     * will then be used instead of attempting to create a new instance of the class.
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Instance {}

    /**
     * Mod ids of the mods required to load this plugin.
     * Leave on the default empty to not care for mod specific filtering.
     *
     * @return The ids of the mods required to load.
     */
    String[] requiredMods() default {};
}
