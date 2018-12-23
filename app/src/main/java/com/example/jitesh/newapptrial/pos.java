package com.example.jitesh.newapptrial;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.Log;

/**
 *  Base For creating new objects be it frog/vehicle or woodplank
 */
public class pos {
    float x;
    float y;

    public pos(float x, float y) {
        this.x = x;
        this.y = y;

    }
    public pos(pos p) {
        this.x = p.x;
        this.y = p.y;
    }

/**
 *  Calculates distance between two objects
 */
    public float distance(pos p) {
//        float dx=0;
//        float dy=0;
//        float dx = (x - (getScreenWidth()-p.x)) + 30;// because 30 is height of bloacks
//        float dy = (y - (getScreenHeight()-p.y)) + 50; // because 50 is width
//        if(y>p.y) {
            float dx = (x - (p.x)) + 30;// because 30 is height of bloacks
            float dy = (y - (p.y)) + 50; // because 50 is width
       // Log.d("DIST","distance is "+Math.sqrt(dx*dx + dy*dy));
            return (float) Math.sqrt(dx*dx + dy*dy);
//        }else{
//            float dx = ((p.x)-x) + 30;// because 30 is height of bloacks
//            float dy = ((p.y)-y) + 50; // because 50 is width
//            Log.d("DIST","distance is "+Math.sqrt(dx*dx + dy*dy));
//            return (float) Math.sqrt(dx*dx + dy*dy);
//        }
//        float dx = (p.x - x)+30;// because 30 is height of bloacks
//        float dy = (p.y - y)+50; // because 50 is width
      //  Log.d("DIST","distance is "+Math.sqrt(dx*dx + dy*dy));
        //return (float) Math.sqrt(dx*dx + dy*dy);
    }


    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
