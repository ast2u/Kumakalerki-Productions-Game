package com.example.kumakalerkiproductions1;

import android.os.SystemClock;

public class coinscore implements Runnable{
int coinzs[];
int coin_d[];
int frame=0;
int ctr=30;

    public void setCoinzs(int[] coinzs) {
        this.coinzs = coinzs;
    }
    public void setCoin_d(int[]coin_d){
        this.coin_d=coin_d;
    }
    @Override
    public void run() {

        while (true) {
            if (frame > 4) {
                frame = 0;
                coinzs[0] = 0;
                coinzs[2] = 200;

            } else {
                coinzs[0] += 200;
                coinzs[2] += 200;
            }
            frame++;

            SystemClock.sleep(120);
        }
    }
}
