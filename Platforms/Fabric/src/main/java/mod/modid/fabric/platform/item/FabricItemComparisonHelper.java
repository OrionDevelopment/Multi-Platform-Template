package mod.modid.fabric.platform.item;

import mod.modid.platforms.core.item.IItemComparisonHelper;
import net.minecraft.world.item.ItemStack;

public final class FabricItemComparisonHelper implements IItemComparisonHelper
{
    private static final FabricItemComparisonHelper INSTANCE = new FabricItemComparisonHelper();

    public static FabricItemComparisonHelper getInstance()
    {
        return INSTANCE;
    }

    private FabricItemComparisonHelper()
    {
    }

    @Override
    public boolean canItemStacksStack(final ItemStack left, final ItemStack right)
    {
        return ItemStack.isSame(left, right) && left.getOrCreateTag().equals(right.getOrCreateTag());
    }
}
