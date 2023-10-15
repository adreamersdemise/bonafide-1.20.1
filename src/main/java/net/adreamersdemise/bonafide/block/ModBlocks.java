package net.adreamersdemise.bonafide.block;

import net.adreamersdemise.bonafide.bonafide;
import net.adreamersdemise.bonafide.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, bonafide.MOD_ID);


    // all Blocks added to the Mod belong down here

    public static final RegistryObject<Block> VOLCANIC_ASH = registerBlock("volcanic_ash",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> ALKALI_SALT_CRUST = registerBlock("alkali_salt_crust",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MAGMA_BLOCK)));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
