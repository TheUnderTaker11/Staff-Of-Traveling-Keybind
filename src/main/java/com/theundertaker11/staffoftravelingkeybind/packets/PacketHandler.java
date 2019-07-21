package com.theundertaker11.staffoftravelingkeybind.packets;

import com.theundertaker11.staffoftravelingkeybind.packets.TeleportPacket.Handler;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
	
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("staffoftravelingkeybind");

	public static void init() {
		INSTANCE.registerMessage(Handler.class, TeleportPacket.class, 0, Side.SERVER);
	}
}
