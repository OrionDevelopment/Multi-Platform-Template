package mod.modid.forge.events;

import mod.modid.Mod;
import mod.modid.platforms.core.util.constants.Constants;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@net.minecraftforge.fml.common.Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Constants.MOD_ID, bus = net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD)
public class OnCommonSetup
{

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onInitialize(final FMLCommonSetupEvent commonSetupEvent)
    {
        Mod.getInstance().onCommonConstruction();
    }
}
