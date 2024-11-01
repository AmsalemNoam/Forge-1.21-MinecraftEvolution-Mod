package net.penguinplay.minecraftevolution;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.penguinplay.minecraftevolution.block.ModBlocks;
import net.penguinplay.minecraftevolution.items.ModCreativeTabs;
import net.penguinplay.minecraftevolution.items.ModItems;
import org.slf4j.Logger;
//very important comment
// The value here should match an entry in the META-INF/mods.toml file
@Mod(MinecraftEvolution.MOD_ID)
public class MinecraftEvolution
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "minecraftevolution";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    public MinecraftEvolution(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTabKey() == ModCreativeTabs.MINECRAFT_EVOLUTION_ITEMS_TAB.getKey()){
            event.accept(ModItems.LUMENITE);
            event.accept(ModItems.DARKITE);
            event.accept(ModItems.RAW_LUMENITE);
            event.accept(ModItems.RAW_DARKITE);
        }

        if(event.getTabKey() == ModCreativeTabs.MINECRAFT_EVOLUTION_BLOCKS_TAB.getKey()){
            event.accept((ModBlocks.LUMENITE_BLOCK));
            event.accept((ModBlocks.DARKITE_BLOCK));
            event.accept((ModBlocks.LUMENITE_ORE));
            event.accept((ModBlocks.DARKITE_ORE));
        }

        if(event.getTabKey() == ModCreativeTabs.MINECRAFT_EVOLUTION_TOOLS_AND_UTILITY_TAB.getKey()){
            event.accept((ModItems.CHISEL));
            event.accept(ModItems.LIGHT_BERRY);
            event.accept(ModItems.DARK_BERRY);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
