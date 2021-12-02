package com.theundertaker11.staffoftravelingkeybind;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import crazypants.enderio.EnderIO;
import crazypants.enderio.teleport.TravelController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class KeybindHandler {
    public static KeyBinding keybindStaffTeleport;

    public static void init() {
        keybindStaffTeleport = new KeyBinding("Staff of Travel Teleport", Keyboard.KEY_G, "Staff Of Traveling Keybind");
        ClientRegistry.registerKeyBinding(keybindStaffTeleport);
    }

    private static long lastBlickTick = -1;


    @SubscribeEvent
    public void clientPlayerTick(PlayerTickEvent event) {
        if(event.side == Side.CLIENT){
            if (KeybindHandler.keybindStaffTeleport.isPressed()) {
                // PacketHandler.INSTANCE.sendToServer(new TeleportPacket());
                EntityPlayer player = Minecraft.getMinecraft().thePlayer;
                ItemStack equipped = null;
                for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
                    ItemStack stack = player.inventory.getStackInSlot(i);
                    if (stack != null) {
                        if(stack.getItem() == EnderIO.itemTravelStaff) {
                            equipped = stack;
                            break;
                        }
                    }
                }
                long ticksSinceBlink = EnderIO.proxy.getTickCount() - lastBlickTick;
                if (ticksSinceBlink < 0) {
                    lastBlickTick = -1;
                }
                if (ticksSinceBlink >= 10) {
                    if (equipped != null && TravelController.instance.doBlink(equipped, player)) {
                        lastBlickTick = EnderIO.proxy.getTickCount();
                    }
                }
            }
        }

    }
}
