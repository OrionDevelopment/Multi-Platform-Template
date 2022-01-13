package mod.modid.fabric;

import mod.modid.Mod;
import mod.modid.fabric.integration.forge.ForgeTags;
import mod.modid.fabric.platform.FabricPlatform;
import mod.modid.fabric.platform.server.FabricServerLifecycleManager;
import mod.modid.platforms.core.IPlatformCore;
import mod.modid.platforms.core.util.constants.Constants;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FabricMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger(Constants.MOD_ID);

    private IPlatformCore platform;
    private Mod           instance;

	@Override
	public void onInitialize() {
        platform = FabricPlatform.getInstance();
        IPlatformCore.Holder.setInstance(platform);

        instance = new Mod();

        setupEvents();
        ForgeTags.init();
	}

    private static void setupEvents() {
        ServerLifecycleEvents.SERVER_STARTING.register(FabricServerLifecycleManager.getInstance()::setServer);
        ServerLifecycleEvents.SERVER_STOPPED.register(server -> FabricServerLifecycleManager.getInstance().clearServer());
    }
}
