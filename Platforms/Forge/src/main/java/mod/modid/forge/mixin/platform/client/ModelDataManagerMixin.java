package mod.modid.forge.mixin.platform.client;

import mod.modid.forge.platform.client.model.data.ForgeBlockModelDataPlatformDelegate;
import mod.modid.platforms.core.client.models.data.IBlockModelData;
import mod.modid.platforms.core.entity.block.IBlockEntityWithModelData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.client.model.ModelDataManager;
import net.minecraftforge.client.model.data.IModelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ModelDataManager.class, remap = false)
public abstract class ModelDataManagerMixin
{
    @Redirect(
      method = "refreshModelData",
      at = @At(
        value = "INVOKE",
        target = "Lnet/minecraft/world/level/block/entity/BlockEntity;getModelData()Lnet/minecraftforge/client/model/data/IModelData;"
      )
    )
    private static IModelData getModelDataRetrieval(final BlockEntity blockEntity) {
        if (blockEntity instanceof IBlockEntityWithModelData blockEntityWithModelData) {
            final IBlockModelData blockModelData = blockEntityWithModelData.getBlockModelData();
            if (!(blockModelData instanceof ForgeBlockModelDataPlatformDelegate platformDelegate)) {
                throw new IllegalStateException("Block model data is not compatible with the current platform.");
            }

            return platformDelegate.getDelegate();
        }

        return blockEntity.getModelData();
    }
}
