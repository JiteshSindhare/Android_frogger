package com.example.jitesh.newapptrial;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class trucks extends View implements Runnable{
    public trucks(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        timer=new Handler();
        this.postDelayed(this,10);
    }

    Handler timer;
    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    vehicles v1=new vehicles();
    vehicles v2=new vehicles();
    vehicles v3=new vehicles();
    boolean moveRight1;

    boolean moveRight2;
    boolean moveRight3;
//    Random r=new Random();
//
//    float truck1=r.nextInt(getScreenWidth());
//
//    float truck2x=r.nextInt(getScreenWidth());
//
//    float truck3x=r.nextInt(getScreenWidth());

    protected void onDraw(Canvas canvas){
//        Paint p=new Paint();
//        float height=this.getHeight();
//        p.setColor(Color.GRAY);
//        Paint p1=new Paint();
//        p1.setColor(Color.BLACK);
//
//        canvas.drawRect(truck1-19,height-20,height+20,truck1+19,p);
//
//        canvas.drawRect(truck2x-19,height-20,height+20,truck2x+19,p1);
//
//        canvas.drawRect(truck3x-19,height-20,height+20,truck3x+19,p);

      //  Log.d("move Direction","pos_x: "+v1.pos_x+" pos_left: "+v1.pos_left);
        canvas.drawRect(v1.pos_left,v1.pos_top,v1.pos_right,v1.pos_bottom,v1.paint_it);
        canvas.drawRect(v2.pos_left,v2.pos_top,v2.pos_right,v2.pos_bottom,v2.paint_it);
        canvas.drawRect(v3.pos_left,v3.pos_top,v3.pos_right,v3.pos_bottom,v3.paint_it);

    }


    @Override
    public void run() {


        if(v1.pos_x>=getScreenWidth()){
            moveRight1=false;
        }

        if(v1.pos_x<=0){
            moveRight1=true;
        }

        if(v2.pos_x>=getScreenWidth()){
            moveRight2=false;
        }

        if(v2.pos_x<=0){
            moveRight2=true;
        }

        if(v3.pos_x>=getScreenWidth()){
            moveRight3=false;
        }

        if(v3.pos_x<=0){
            moveRight3=true;
        }

       v1.pos_x= v1.move(moveRight1);
       v2.pos_x=v2.move(moveRight2);
       v3.pos_x=v3.move(moveRight3);
       invalidate();
        this.postDelayed(this,10);
    }
}
