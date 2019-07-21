package com.theundertaker11.staffoftravelingkeybind;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import org.apache.logging.log4j.Logger;

import com.theundertaker11.staffoftravelingkeybind.packets.PacketHandler;

@Mod(modid = SOTKeybindMain.MODID, name = SOTKeybindMain.NAME, version = SOTKeybindMain.VERSION)
public class SOTKeybindMain
{
    public static final String MODID = "staffoftravelingkeybind";
    public static final String NAME = "Staff Of Traveling Keybind";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	PacketHandler.init();
    	if (event.getSide() == Side.CLIENT)
			KeybindHandler.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
}
