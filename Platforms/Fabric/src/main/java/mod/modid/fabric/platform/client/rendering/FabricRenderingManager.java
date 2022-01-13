package mod.modid.fabric.platform.client.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.modid.fabric.platform.client.rendering.rendertype.FabricRenderTypeManager;
import mod.modid.platforms.core.client.rendering.IRenderingManager;
import mod.modid.platforms.core.client.rendering.type.IRenderTypeManager;
import mod.modid.platforms.core.fluid.FluidInformation;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

import static mod.modid.fabric.platform.fluid.FabricFluidManager.makeVariant;

public final class FabricRenderingManager implements IRenderingManager
{
    private static final FabricRenderingManager INSTANCE = new FabricRenderingManager();
    
    public static FabricRenderingManager getInstance() {
        return INSTANCE;
    }

    private FabricRenderingManager() {
    }

    @Override
    public void renderModel(
      final PoseStack.Pose last,
      final VertexConsumer buffer,
      final BlockState defaultBlockState,
      final BakedModel model,
      final float r,
      final float g,
      final float b,
      final int combinedLight,
      final int combinedOverlay)
    {
        Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(last, buffer, defaultBlockState, model, r, g, b, combinedLight, combinedOverlay);
    }

    @Override
    public ResourceLocation getFlowingFluidTexture(final FluidInformation fluidInformation)
    {
        return FluidVariantRendering.getSprite(makeVariant(fluidInformation)).getName();
    }

    @Override
    public ResourceLocation getFlowingFluidTexture(final Fluid fluid)
    {
        return getFlowingFluidTexture(new FluidInformation(fluid));
    }

    @Override
    public ResourceLocation getStillFluidTexture(final FluidInformation fluidInformation)
    {
        return FluidVariantRendering.getSprite(makeVariant(fluidInformation)).getName();
    }

    @Override
    public ResourceLocation getStillFluidTexture(final Fluid fluid)
    {
        return getFlowingFluidTexture(new FluidInformation(fluid));
    }

    @Override
    public @NotNull IRenderTypeManager getRenderTypeManager()
    {
        return FabricRenderTypeManager.getInstance();
    }

    @Override
    public void registerISTER(final Item item, final BlockEntityWithoutLevelRenderer renderer)
    {
        BuiltinItemRendererRegistry.INSTANCE.register(
          item,
          renderer::renderByItem
        );
    }
}
