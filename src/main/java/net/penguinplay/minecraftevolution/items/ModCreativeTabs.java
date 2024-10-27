package net.penguinplay.minecraftevolution.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.penguinplay.minecraftevolution.MinecraftEvolution;
import net.penguinplay.minecraftevolution.block.ModBlocks;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinecraftEvolution.MOD_ID);

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static final RegistryObject<CreativeModeTab> MINECRAFT_EVOLUTION_ITEMS_TAB = CREATIVE_MODE_TABS
            .register("minecraft_evolution_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.LUMENITE.get()))
            .title(Component.translatable("creativetab.minecraftevolution.minecraft_evolution_items"))
            .build());

    public static final RegistryObject<CreativeModeTab> MINECRAFT_EVOLUTION_BLOCKS_TAB = CREATIVE_MODE_TABS
            .register("minecraft_evolution_blocks_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.LUMENITE_BLOCK.get()))
                    .withTabsBefore(MINECRAFT_EVOLUTION_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.minecraftevolution.minecraft_evolution_blocks"))
                    .build());

    public static final RegistryObject<CreativeModeTab> MINECRAFT_EVOLUTION_TOOLS_AND_UTILITY_TAB = CREATIVE_MODE_TABS
            .register("minecraft_evolution_tools_and_utility_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CHISEL.get()))
                    .withTabsBefore(MINECRAFT_EVOLUTION_BLOCKS_TAB.getId())
                    .title(Component.translatable("creativetab.minecraftevolution.minecraft_evolution_tools_and_utility"))
                    .build());













}
