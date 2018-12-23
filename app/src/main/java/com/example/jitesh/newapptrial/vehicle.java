package com.example.jitesh.newapptrial;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class vehicle extends sprite {
    float xc;
    float yc;
    float pt;
    float pb;
    float pl;
    float pr;
    int width;
    int height;

    //............Initializing vehicles..........

    public vehicle(float x,float y){
        //this.pos=new pos(x,(y));// we will give y once 100 n once 1080-100

        this.pos=new pos(x,((getScreenHeight()-400)-y));// we will give y once 100 n once 1080-100
    }

    // TO draw rectangle as a vehicle which is not used now since image is being used now
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
       // c.drawRect(pl,pt,pr,pb,p);
        p.setColor(Color.GRAY);

    }

    // TO draw image of vehicle

    public void draw1(Canvas c, Paint p,Bitmap bm) {
     //   Log.d("Vehicle"," pos x "+pos.x+" pos y"+pos.y );
        c.drawBitmap(bm,pos.x,pos.y,p); //(getScreenHeight()-400)-pos.y-----(c.getHeight()-200)-pos.y

    }

    // .............NOT used now............
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

    public int send_width(){
        return width;
    }

    //...... TO get width..........
    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    //........TO get Height............
    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
