package com.example.kumakalerkiproductions1;

import android.os.SystemClock;

public class playerRight implements Runnable {
    int player_s1[];
    int frame=0;

    public void setPlayers1(int[] player_s1) {
        this.player_s1= player_s1;
    }
    @Override
    public void run() {
        while (true) {
            if (frame > 7) {
                frame = 0;
                player_s1[0] = 0;
                player_s1[2] = 64;

            } else {
                player_s1[0] += 64;
                player_s1[2] += 64;
            }
            frame++;
            SystemClock.sleep(80);

        }
    }
}
