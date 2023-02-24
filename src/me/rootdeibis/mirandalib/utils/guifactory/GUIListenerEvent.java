package me.rootdeibis.mirandalib.utils.guifactory;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListenerEvent implements Listener {
    

    @EventHandler
    public void onPlayerInventoryClickEvent(InventoryClickEvent e) {


        if(e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();

            if(player.getOpenInventory().getTopInventory().getHolder() instanceof GUIMenu) {
                if(e.getClickedInventory().getHolder() instanceof GUIMenu) {
                    int clickedSlot = e.getSlot();

                    GUIMenu menu = (GUIMenu) e.getClickedInventory().getHolder();

                    if(!menu.isEditable()) e.setCancelled(true);

                    GUIButton button = menu.getButtons().find(btn -> btn.getSlot() == clickedSlot);

                    if(button == null) return;

                    if(!button.isMovable()) e.setCancelled(true);


                    button.click(e);

                }




            }
        }

    }


}
