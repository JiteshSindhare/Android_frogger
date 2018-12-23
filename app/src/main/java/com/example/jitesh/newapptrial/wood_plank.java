package com.example.jitesh.newapptrial;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class wood_plank extends sprite {
    float xc;
    float yc;
    float pt;
    float pb;
    float pl;
    float pr;
    int width;
    int height;
/**
 * Initialize wood plank
 */
    public wood_plank(float x,float y){
        this.pos=new pos(x,((getScreenHeight()-950)-y));
    }
/**
 *  Drawing rectangle of wood plank
 */
    @Override
    public void draw(Canvas c, Paint p) {
        height=c.getHeight()-84; // because that will be the starting point of frog.
        width=c.getWidth();

        xc=pos.y; //we have to pass position of block in width side in y
        yc=height-pos.x;
        pt=yc-30;
        pb=yc+30;
        pl=xc-50;
        pr=xc+50;
     //   c.drawRect(pl,pt,pr,pb,p);
        p.setColor(Color.rgb(80,38,24));  // it is brown colour
    }

    /**
     * TO draw image of wood plank
     */
    public void draw1(Canvas c, Paint p,Bitmap bm) {
      //  Log.d("WOOD"," Inside wood plank " );

        c.drawBitmap(bm,pos.x,pos.y,p);//(getScreenHeight()-750)-pos.y--------((c.getHeight()-800)-pos.y)
    }

    public int move(){
        int  m=0; // we will treat 1 as have to move right otherwise have to move left.
        if(pl<=0){
            xc=this.width-100;
            m=1;
        }else if(pr>=width){
            xc=100;
            m=0;
        }
        return m;
    }

    public int get_canvas_width(){
        return width;
    }

    /**
     * .....get screen width.........
     */
    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
    //int width=getScreenWidth();
    /**
     * ..........get screen height.........
     */
    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
