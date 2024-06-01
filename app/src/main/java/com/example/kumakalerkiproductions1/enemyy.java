package com.example.kumakalerkiproductions1;

import android.os.SystemClock;

public class enemyy implements Runnable{
    int enemys1[];
    int frame=0;

    public void setEnemys1(int[] enemys1) {
        this.enemys1 = enemys1;
    }

    @Override
    public void run() {
        while (true) {
            if (frame > 3) {
                frame = 0;
                enemys1[0] = 0;
                enemys1[2] = 125;

            } else {
                enemys1[0] += 125;
                enemys1[2] += 125;
            }
            frame++;
            SystemClock.sleep(120);
        }

    }
}
