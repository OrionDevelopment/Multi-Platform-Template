package mod.modid.api.addons;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Triggers mod to create an instance of the class and call its callback method
 * on load.
 */
@Retention( RetentionPolicy.RUNTIME )
public @interface ChiselsAndBitsAddon
{

}
