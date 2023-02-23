package me.rootdeibis.mirandalib.utils.guifactory;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListenerEvent {
    

    @EventHandler
    public void onPlayerInventoryClickEvent(InventoryClickEvent e) {


        if(e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();

            if(player.getOpenInventory().getTopInventory() instanceof GUIMenu) {
                e.setCancelled(true);

                if(e.getClickedInventory() instanceof GUIMenu) {
                    int clickedSlot = e.getSlot();

                    GUIMenu menu = (GUIMenu) e.getClickedInventory();
                    GUIButton button = menu.getButtons().find(btn -> btn.getSlot() == clickedSlot);

                    if(button == null) return;

                    button.click(e);

                }




            }
        }

    }


}
