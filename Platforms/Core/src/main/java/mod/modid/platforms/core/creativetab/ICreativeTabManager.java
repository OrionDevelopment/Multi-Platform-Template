package mod.modid.platforms.core.creativetab;

import mod.modid.platforms.core.IPlatformCore;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.IntFunction;

/**
 * Manager which is used to handle the creation of new creative tabs.
 */
public interface ICreativeTabManager
{

    /**
     * The current instance of on the current platform.
     *
     * @return The current manager.
     */
    static ICreativeTabManager getInstance() {
        return IPlatformCore.getInstance().getCreativeTabManager();
    }

    /**
     * Registers a new creative tab made by the builder.
     *
     * @param builder The builder for the tab.
     * @return The newly registered tab.
     */
    CreativeModeTab register(final IntFunction<CreativeModeTab> builder);
}
