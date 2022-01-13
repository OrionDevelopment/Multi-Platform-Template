package mod.modid.fabric.platform.client;

import mod.modid.fabric.platform.client.keys.FabricKeyBindingManager;
import mod.modid.fabric.platform.client.rendering.FabricColorManager;
import mod.modid.fabric.platform.client.rendering.FabricRenderingManager;
import mod.modid.fabric.platform.client.rendering.model.data.ModelDataBuilder;
import mod.modid.fabric.platform.client.rendering.model.data.ModelDataKey;
import mod.modid.fabric.platform.client.rendering.model.data.FabricModelDataManager;
import mod.modid.platforms.core.client.IClientManager;
import mod.modid.platforms.core.client.key.IKeyBindingManager;
import mod.modid.platforms.core.client.models.data.IModelDataBuilder;
import mod.modid.platforms.core.client.models.data.IModelDataKey;
import mod.modid.platforms.core.client.models.data.IModelDataManager;
import mod.modid.platforms.core.client.rendering.IColorManager;
import mod.modid.platforms.core.client.rendering.IRenderingManager;
import org.jetbrains.annotations.NotNull;

public final class FabricClientManager implements IClientManager
{
    private static final FabricClientManager INSTANCE = new FabricClientManager();

    public static FabricClientManager getInstance()
    {
        return INSTANCE;
    }

    private FabricClientManager()
    {
    }

    @Override
    public @NotNull IRenderingManager getRenderingManager()
    {
        return FabricRenderingManager.getInstance();
    }

    @Override
    public @NotNull IModelDataBuilder createNewModelDataBuilder()
    {
        return new ModelDataBuilder();
    }

    @Override
    public @NotNull <T> IModelDataKey<T> createNewModelDataKey()
    {
        return new ModelDataKey<>();
    }

    @Override
    public @NotNull IModelDataManager getModelDataManager()
    {
        return FabricModelDataManager.getInstance();
    }

    @Override
    public @NotNull IColorManager getColorManager()
    {
        return FabricColorManager.getInstance();
    }

    @Override
    public @NotNull IKeyBindingManager getKeyBindingManager()
    {
        return FabricKeyBindingManager.getInstance();
    }
}
