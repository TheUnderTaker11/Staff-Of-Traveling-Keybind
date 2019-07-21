package com.theundertaker11.staffoftravelingkeybind;

import org.lwjgl.input.Keyboard;

import com.theundertaker11.staffoftravelingkeybind.packets.PacketHandler;
import com.theundertaker11.staffoftravelingkeybind.packets.TeleportPacket;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class KeybindHandler {
	public static KeyBinding keybindStaffTeleport;

	public static void init() {

		keybindStaffTeleport = new KeyBinding("Staff of Travel Teleport", Keyboard.KEY_G, "Staff Of Traveling Keybind");
		ClientRegistry.registerKeyBinding(keybindStaffTeleport);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void clientPlayerTick(TickEvent.PlayerTickEvent event) {

		if (KeybindHandler.keybindStaffTeleport.isPressed()) {
			PacketHandler.INSTANCE.sendToServer(new TeleportPacket());
		}

	}
}
