package net.adreamersdemise.bonafide.item;

import net.adreamersdemise.bonafide.block.ModBlocks;
import net.adreamersdemise.bonafide.bonafide;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, bonafide.MOD_ID);


    // Add Blocks to Creative Tab as pOutput below

    public static final RegistryObject<CreativeModeTab> BONAFIDE_TAB = CREATIVE_MODE_TABS.register("bonafide_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.VOLCANIC_ASH.get()))
                    .title(Component.translatable("creativetab.bonafide_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.VOLCANIC_ASH.get());
                        pOutput.accept(ModBlocks.ALKALI_SALT_CRUST.get());


                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
