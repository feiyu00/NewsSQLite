package com.example.localization.utils;

import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class ToastTime {
    public static void showMyToast(final Toast toast, final  int cnt){
        final Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        },0, Toast.LENGTH_LONG);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        },cnt);
    }
}
