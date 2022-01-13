package mod.modid.forge.platform.registry.delegates;

import mod.modid.platforms.core.registries.ISizedIdMap;
import net.minecraft.core.IdMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

public class ForgeIdMapperPlatformDelegate<T> implements ISizedIdMap<T>
{
    private final IdMapper<T> delegate;

    public ForgeIdMapperPlatformDelegate(final IdMapper<T> delegate) {this.delegate = delegate;}

    @Override
    public int size()
    {
        return delegate.size();
    }

    @Override
    public int getId(final @NotNull T value)
    {
        return delegate.getId(value);
    }

    @Nullable
    @Override
    public T byId(final int id)
    {
        return delegate.byId(id);
    }

    @NotNull
    @Override
    public Iterator<T> iterator()
    {
        return delegate.iterator();
    }
}
