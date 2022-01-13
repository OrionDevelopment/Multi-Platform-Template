package mod.modid.forge.client.core;

import mod.modid.platforms.core.util.constants.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.IModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.function.BiConsumer;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeClient
{

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onModelRegistry(final ModelRegistryEvent event)
    {
        ForgeClient.onModelRegistry(
          ModelLoaderRegistry::registerLoader
        );
    }

    @OnlyIn(Dist.CLIENT)
    public static void onModelRegistry(final BiConsumer<ResourceLocation, IModelLoader<?>> registrar)
    {

    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onInitialize(final FMLClientSetupEvent clientSetupEvent)
    {


    }
}
