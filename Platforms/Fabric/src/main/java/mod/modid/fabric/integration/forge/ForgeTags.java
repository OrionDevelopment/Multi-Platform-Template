package mod.modid.fabric.integration.forge;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;

public class ForgeTags
{
    public static void init ()
    {
        Items.init();
    }

    public static class Items
    {
        private static void init(){}

        //You might need compatibility with forge owned tags.
        //Add them here.

        private static Tag.Named<Item> tag(String name)
        {
            return ItemTags.bind("forge:" + name);
        }
    }
}
