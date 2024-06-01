package com.example.kumakalerkiproductions1;

import android.os.SystemClock;

public class enemyplayer implements Runnable{
    int player_enemys1[];
    int frame=0;

    public void setPlayer_enemys1(int[] player_enemys1) {
        this.player_enemys1= player_enemys1;
    }
    @Override
    public void run() {
        while (true) {
            if (frame > 4) {
                frame = 0;
                player_enemys1[0] = 0;
                player_enemys1[2] = 64;

            } else {
                player_enemys1[0] += 64;
                player_enemys1[2] += 64;
            }
            frame++;
            SystemClock.sleep(150);

        }
    }
}
