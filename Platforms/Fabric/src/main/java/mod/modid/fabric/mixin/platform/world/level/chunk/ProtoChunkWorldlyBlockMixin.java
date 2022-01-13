package mod.modid.fabric.mixin.platform.world.level.chunk;

import mod.modid.platforms.core.block.IBlockWithWorldlyProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ProtoChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ProtoChunk.class)
public abstract class ProtoChunkWorldlyBlockMixin implements BlockGetter
{

    @Redirect(
      method = "setBlockState",
      at = @At(
        value = "INVOKE",
        target = "Lnet/minecraft/world/level/block/state/BlockState;getLightEmission()I"
      )
    )
    public int redirectGetBlockStateLightEmission(BlockState blockState, final BlockPos blockPos)
    {
        if (blockState.getBlock() instanceof IBlockWithWorldlyProperties blockWithWorldlyProperties)
        {
            return blockWithWorldlyProperties.getLightEmission(
              blockState, this, blockPos
            );
        }
        return blockState.getLightEmission();
    }
}
