package com.example.jitesh.newapptrial;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;



public class frog extends sprite{
    int width=getScreenWidth();
    float start_x=width/2;
    float start_y=getScreenHeight()-250;;
 //   float start_y=1550;;
    Paint frog_paint;
    int radius_of_frog=34;

/**
 * Intilizing Frog
 */
    public frog(){
    pos=new pos(start_x,start_y);
//        frog_paint.setColor(Color.GREEN);
    }



    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /**
     * TO draw circle for frog . which is not used now
     */
    @Override
    public void draw(Canvas c, Paint p) {
    //    c.drawCircle(pos.x,pos.y,radius_of_frog,p);
    }

    /**
     * TO draw bitmap image of Frog
     */
    public void draw(Canvas c, Paint p,Bitmap bm) {

        c.drawBitmap(bm,pos.x,pos.y,p);
    }
    /**
    *      Checks if Frog is hit by Vehicle
    */
    public boolean hitBy(vehicle v){
        if(v.pos.distance(pos)<=100){
            return true;
        }else{
            return false;
        }
    }

    /**
     *  Checks if Frog is hit by Wood_plank
     */
    public boolean hitBy(wood_plank w){
        if(w.pos.distance(pos)<=85){
            if(w.pos.x>=getScreenWidth()-20){
                pos.x=getScreenWidth();
                pos.y=w.pos.y;
            }else{
            pos.x=w.pos.x;
            pos.y=w.pos.y;}
            return true;
        }else{
            return false;
        }
    }
/**
 * NOT used now can be usd instead of Using on_sea of "Game.class"
 */
    public boolean on_sea(float y, float top){
        if( pos.y<y && pos.y>top)return true;

        return false;
    }

    public pos get(){
        return pos;
    }
}
