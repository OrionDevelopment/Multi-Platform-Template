package mod.modid.forge.platform.entity;

import mod.modid.platforms.core.entity.IPlayerInventoryManager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.FakePlayer;

public class ForgePlayerInventoryManager implements IPlayerInventoryManager
{
    private static final ForgePlayerInventoryManager INSTANCE = new ForgePlayerInventoryManager();

    public static ForgePlayerInventoryManager getInstance()
    {
        return INSTANCE;
    }

    private ForgePlayerInventoryManager()
    {
    }

    @Override
    public void giveToPlayer(final Player player, final ItemStack stack)
    {
        if (player instanceof FakePlayer) {
            player.drop(stack, false, false);
        } else {
            player.getInventory().placeItemBackInInventory(stack);
        }
    }
}
