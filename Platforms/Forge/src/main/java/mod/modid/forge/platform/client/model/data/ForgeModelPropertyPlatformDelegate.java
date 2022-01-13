package mod.modid.forge.platform.client.model.data;

import mod.modid.platforms.core.client.models.data.IModelDataKey;
import net.minecraftforge.client.model.data.ModelProperty;

public class ForgeModelPropertyPlatformDelegate<T> implements IModelDataKey<T>
{

    private final ModelProperty<T> property;

    public ForgeModelPropertyPlatformDelegate(final ModelProperty<T> property) {this.property = property;}

    public ModelProperty<T> getProperty()
    {
        return property;
    }
}
