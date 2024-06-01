package com.example.kumakalerkiproductions1;

import android.os.SystemClock;

public class character1 implements Runnable {
    int player_gRight[];
    int frame=0;

    public void setPlayer_gRight(int[] player_gRight) {
        this.player_gRight = player_gRight;
    }

    @Override
    public void run() {
        while (true) {
            if (frame > 7) {
                frame = 0;
                player_gRight[0] = 0;
                player_gRight[2] = 64;

            } else {
                player_gRight[0] += 64;
                player_gRight[2] += 64;
            }
            frame++;
           SystemClock.sleep(50);

        }
    }
}
