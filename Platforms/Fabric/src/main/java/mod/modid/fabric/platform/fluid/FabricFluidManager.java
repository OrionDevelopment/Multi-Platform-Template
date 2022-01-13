package mod.modid.fabric.platform.fluid;

import mod.modid.platforms.core.dist.DistExecutor;
import mod.modid.platforms.core.fluid.FluidInformation;
import mod.modid.platforms.core.fluid.IFluidManager;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

import java.util.Optional;

public class FabricFluidManager implements IFluidManager
{
    private static final FabricFluidManager INSTANCE = new FabricFluidManager();

    public static FabricFluidManager getInstance()
    {
        return INSTANCE;
    }

    private FabricFluidManager()
    {
    }

    @Override
    public Optional<FluidInformation> get(final ItemStack stack)
    {
        try(Transaction context = Transaction.openOuter()) {
            final Storage<FluidVariant> target = FluidStorage.ITEM.find(stack, ContainerItemContext.withInitial(stack));
            if (target == null)
                return Optional.empty();

            final Iterable<StorageView<FluidVariant>> fluids;
            fluids = target.iterable(context);

            if (!fluids.iterator().hasNext())
                return Optional.empty();

            final StorageView<FluidVariant> view = fluids.iterator().next();

            return Optional.of(
              new FluidInformation(
                view.getResource().getFluid(),
                view.getAmount(),
                view.getResource().copyNbt()
              )
            );
        }
    }

    @Override
    public ItemStack extractFrom(final ItemStack stack, final long amount)
    {
        try(final Transaction context = Transaction.openOuter()) {
            final Optional<FluidInformation> contained =
              get(stack);

            return contained.map(fluid -> {
                final FluidVariant variant = makeVariant(fluid);
                final ContainerItemContext containerContext = ContainerItemContext.withInitial(stack);

                FluidStorage.ITEM.find(stack, containerContext)
                  .extract(variant, amount, context);

                final StorageView<ItemVariant> itemVariant = containerContext.getMainSlot().iterator(context).next();
                return itemVariant.getResource().toStack((int) itemVariant.getAmount());
            }).orElse(ItemStack.EMPTY);
        }
    }

    @Override
    public ItemStack insertInto(final ItemStack stack, final FluidInformation fluidInformation)
    {
        try(final Transaction context = Transaction.openOuter()) {
            final Optional<FluidInformation> contained =
              get(stack);

            return contained.map(fluid -> {
                final FluidVariant variant = makeVariant(fluid);
                final ContainerItemContext containerContext = ContainerItemContext.withInitial(stack);

                FluidStorage.ITEM.find(stack, containerContext)
                  .insert(variant, fluidInformation.amount(), context);

                final StorageView<ItemVariant> itemVariant = containerContext.getMainSlot().iterator(context).next();
                return itemVariant.getResource().toStack((int) itemVariant.getAmount());
            }).orElse(ItemStack.EMPTY);
        }
    }

    @Override
    public int getFluidColor(final FluidInformation fluid)
    {
        return DistExecutor.unsafeRunForDist(
          () -> () -> FluidVariantRendering.getColor(makeVariant(fluid)),
          () -> () -> 0xffffff
        );
    }

    @Override
    public Component getDisplayName(final Fluid fluid)
    {
        return DistExecutor.unsafeRunForDist(
          () -> () -> FluidVariantRendering.getName(makeVariant(new FluidInformation(fluid))),
          () -> () -> fluid.defaultFluidState().createLegacyBlock().getBlock().getName()
        );
    }

    public static FluidVariant makeVariant(final FluidInformation fluid) {
        if (fluid.data() == null)
            return FluidVariant.of(fluid.fluid());

        return FluidVariant.of(fluid.fluid(), fluid.data());
    }
}
