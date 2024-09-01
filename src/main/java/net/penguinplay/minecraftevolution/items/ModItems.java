package net.penguinplay.minecraftevolution.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.penguinplay.minecraftevolution.MinecraftEvolution;

public class ModItems {
    //List of the Items under our MOD_ID
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftEvolution.MOD_ID);
    //The Item we want to add(In this case the Item Lumenite) it will add it to the game but it will be NULL for the time being till we change it
    //Need to add the items to the creative menu in the function addCreative in the main program
    public static final RegistryObject<Item> LUMENITE = ITEMS.register("lumenite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARKITE = ITEMS.register("darkite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_LUMENITE = ITEMS.register("raw_lumenite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_DARKITE = ITEMS.register("raw_darkite", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }



}