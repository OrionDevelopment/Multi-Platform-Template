package mod.modid.forge.platform.client;

import mod.modid.forge.platform.client.color.ForgeColorManager;
import mod.modid.forge.platform.client.key.ForgeKeyBindingManager;
import mod.modid.forge.platform.client.model.data.ForgeModelDataManager;
import mod.modid.forge.platform.client.model.data.ForgeModelDataMapBuilderPlatformDelegate;
import mod.modid.forge.platform.client.model.data.ForgeModelPropertyPlatformDelegate;
import mod.modid.forge.platform.client.rendering.ForgeRenderingManager;
import mod.modid.platforms.core.client.IClientManager;
import mod.modid.platforms.core.client.key.IKeyBindingManager;
import mod.modid.platforms.core.client.models.data.IModelDataBuilder;
import mod.modid.platforms.core.client.models.data.IModelDataKey;
import mod.modid.platforms.core.client.models.data.IModelDataManager;
import mod.modid.platforms.core.client.rendering.IColorManager;
import mod.modid.platforms.core.client.rendering.IRenderingManager;
import net.minecraftforge.client.model.data.ModelProperty;
import org.jetbrains.annotations.NotNull;

public class ForgeClientManager implements IClientManager
{
    private static final ForgeClientManager INSTANCE = new ForgeClientManager();

    public static ForgeClientManager getInstance()
    {
        return INSTANCE;
    }

    private ForgeClientManager()
    {
    }

    @Override
    public @NotNull IRenderingManager getRenderingManager()
    {
        return ForgeRenderingManager.getInstance();
    }

    @Override
    public @NotNull IModelDataBuilder createNewModelDataBuilder()
    {
        return new ForgeModelDataMapBuilderPlatformDelegate();
    }

    @Override
    public @NotNull <T> IModelDataKey<T> createNewModelDataKey()
    {
        return new ForgeModelPropertyPlatformDelegate<>(new ModelProperty<>());
    }

    @Override
    public @NotNull IModelDataManager getModelDataManager()
    {
        return ForgeModelDataManager.getInstance();
    }

    @Override
    public @NotNull IColorManager getColorManager()
    {
        return ForgeColorManager.getInstance();
    }

    @Override
    public @NotNull IKeyBindingManager getKeyBindingManager()
    {
        return ForgeKeyBindingManager.getInstance();
    }
}
