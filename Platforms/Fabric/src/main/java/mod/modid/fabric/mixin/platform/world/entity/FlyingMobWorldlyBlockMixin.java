package mod.modid.fabric.mixin.platform.world.entity;

import mod.modid.platforms.core.block.IBlockWithWorldlyProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FlyingMob.class)
public abstract class FlyingMobWorldlyBlockMixin extends Mob
{
    protected FlyingMobWorldlyBlockMixin(final EntityType<? extends Mob> entityType, final Level level)
    {
        super(entityType, level);
    }

    @Redirect(
      method = "travel",
      at = @At(
        value = "INVOKE",
        target = "Lnet/minecraft/world/level/block/Block;getFriction()F"
      )
    )
    public float redirectGetBlockFriction(Block block)
    {
        final BlockPos pos = new BlockPos(this.getX(), this.getY() - 1.0D, this.getZ());
        final BlockState blockState = this.level.getBlockState(pos);
        if (blockState.getBlock() instanceof IBlockWithWorldlyProperties blockWithWorldlyProperties) {
            return blockWithWorldlyProperties.getFriction(blockState, this.level, pos, this);
        }

        return block.getFriction();
    }
}
