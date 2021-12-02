package com.theundertaker11.staffoftravelingkeybind;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = SOTKeybindMain.MODID, name = SOTKeybindMain.NAME, version = SOTKeybindMain.VERSION, acceptedMinecraftVersions = "*")
public class SOTKeybindMain
{
    public static final String MODID = "sotkeybind";
    public static final String NAME = "Staff Of Traveling Keybind";
    public static final String VERSION = "1.3";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        if (event.getSide() == Side.CLIENT) {
            KeybindHandler.init();
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        if (event.getSide() == Side.CLIENT) {
            MinecraftForge.EVENT_BUS.register(new KeybindHandler());
            FMLCommonHandler.instance().bus().register(new KeybindHandler());
        }
    }
}
