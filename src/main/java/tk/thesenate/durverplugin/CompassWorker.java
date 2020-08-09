package tk.thesenate.durverplugin;

import org.bukkit.entity.Player;

import java.util.UUID;

import static org.bukkit.Bukkit.*;

public class CompassWorker extends ManhuntCmd implements Runnable {

//    public void stopRunning() {
//        ManhuntCmd.manhuntOngoing = false;
//    }

    @Override
    public void run() {

        while (true) {
            //getLogger().info(String.valueOf(ManhuntCmd.manhuntOngoing));

//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            if (ManhuntCmd.manhuntOngoing) {
                //getLogger().info("despacito");
                for (UUID l : ManhuntCmd.hunters) {
                    Player hunter = getPlayer(l);
                    if (hunter == null) {
                        ManhuntCmd.hunters.remove(l);
                        continue;
                    }
                    //getLogger().info("trying to set compass");
                    if (!ManhuntCmd.hunters.contains(getNearestPlayer(hunter).getUniqueId())) {
                        //getLogger().info("setting compass");
                        hunter.setCompassTarget(getNearestPlayer(hunter).getLocation());
                    }
                }

                if (!ManhuntCmd.manhuntOngoing) {
                    break;
                }

            }
        }
    }

}
