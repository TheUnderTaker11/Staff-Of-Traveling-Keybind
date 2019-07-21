package com.theundertaker11.staffoftravelingkeybind.packets;

import crazypants.enderio.base.EnderIO;
import crazypants.enderio.base.teleport.TravelController;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class TeleportPacket implements IMessage {

	public TeleportPacket() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
	}

	@Override
	public void toBytes(ByteBuf buf) {
	}

	public static class Handler implements IMessageHandler<TeleportPacket, IMessage> {

		private long lastBlickTick = 0;

		@Override
		public IMessage onMessage(final TeleportPacket message, final MessageContext ctx) {
			IThreadListener mainThread = (WorldServer) ctx.getServerHandler().player.getEntityWorld();
			mainThread.addScheduledTask(new Runnable() {
				@Override
				public void run() {
					net.minecraft.entity.player.EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
					ItemStack equipped = ItemStack.EMPTY;
					for (int i = 0; i < serverPlayer.inventory.getSizeInventory(); i++) {
						ItemStack stack = serverPlayer.inventory.getStackInSlot(i);
						if(stack.getItem() == Item.REGISTRY.getObject(new ResourceLocation("enderio:item_travel_staff"))) {
							equipped = stack;
							break;
						}
					}
					//System.out.println("Yeetus the feetus");
					if (!equipped.isEmpty() && TravelController.instance.doBlink(equipped, EnumHand.MAIN_HAND, serverPlayer)) {
						lastBlickTick = EnderIO.proxy.getTickCount();
					}
				}
			});
			return null;
		}
	}
}
