package mod.modid.fabric.mixin.platform.world.level.chunk;

import mod.modid.platforms.core.block.IBlockWithWorldlyProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.*;
import net.minecraft.world.level.levelgen.blending.BlendingData;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Mixin(value = LevelChunk.class, priority = Integer.MIN_VALUE)
public abstract class LevelChunkWorldlyBlockMixin extends ChunkAccess
{

    public LevelChunkWorldlyBlockMixin(
      final ChunkPos chunkPos,
      final UpgradeData upgradeData,
      final LevelHeightAccessor levelHeightAccessor,
      final Registry<Biome> registry,
      final long l,
      @Nullable final LevelChunkSection[] levelChunkSections,
      @Nullable final BlendingData blendingData)
    {
        super(chunkPos, upgradeData, levelHeightAccessor, registry, l, levelChunkSections, blendingData);
    }

    @Shadow public abstract BlockState getBlockState(final BlockPos param0);

    @Shadow public abstract Level getLevel();

    /**
     * @author mod
     * @reason It is not possible to efficiently inject into the lambda for now.
     */
    @Overwrite
    public Stream<BlockPos> getLights()
    {
        return StreamSupport.stream(BlockPos.betweenClosed(
          this.chunkPos.getMinBlockX(),
          this.getMinBuildHeight(),
          this.chunkPos.getMinBlockZ(),
          this.chunkPos.getMaxBlockX(),
          this.getMaxBuildHeight() - 1,
          this.chunkPos.getMaxBlockZ()).spliterator(), false).filter((blockPos) -> {
            final BlockState blockState = getBlockState(blockPos);
            if (blockState.getBlock() instanceof IBlockWithWorldlyProperties blockWithWorldlyProperties) {
                return blockWithWorldlyProperties.getLightEmission(
                  blockState,getLevel(),blockPos
                ) != 0;
            }

            return blockState.getLightEmission() != 0;
        });
    }


}
