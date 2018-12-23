package com.example.jitesh.newapptrial;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class wood_planks extends ArrayList<wood_plank> {
    public  final float step=90;
    public  int speed=5;
    private Boolean movingRight;
    int speed_bound=15;
    Random rand=new Random();

    /**
     * ........ To create wood_planks
     */

    public  wood_planks river_plank(int dif){
        float y=30;
        float x=0;
        int limit=0;
        if(dif==1){// ...initially diff was made to so that it can be used as a difficulty
            //speed=5;
            speed_bound=15;
            limit =7;
        }else if(dif==2){
            //speed=10;
            speed_bound=20;
            limit=8;
        }else{
            //speed=15;
            speed_bound=30;
            limit=5;
        }

        wood_planks wp=new wood_planks();

        for(int i=0;i<limit;i++){
            if(i%2==0 || i==1){
               // x=1080-100;
                x=getScreenWidth(); // to put plank on right side of the screen
                wp.movingRight=false;
            }else{
                x=0; // to put plank on left side of the screen
                wp.movingRight=true;
            }
            wp.add(new wood_plank(x,y));
            y=y+step;
        }
        return wp;
    }
/**
 * TO draw rectangle for wood plank
 */
    public void draw(Canvas canvas, Paint paint) {
        for (wood_plank w:this) w.draw(canvas, paint);
    }

    /**
     * ......This method is to draw wood plank image
     */
    public void draw1(Canvas c, Paint p,Bitmap bm) {
     //   Log.d("PLANKS"," Inside drawing lots of woodplanks " );

        for (wood_plank w: this ) {
         //   Log.d("PLANKS"," Inside drawing lots of woodplanks " );
            w.draw1(c, p, bm);
        }
    }

    /**
     * This method is used to make planks move
     */
    public void step(){
        // for moving the wood planks
        for(wood_plank w:this){

            if(w.pos.x>getScreenWidth()){
                w.pos.x=0;
            }else if(w.pos.x<=0){
                w.pos.x=getScreenWidth();
            }
            // int m=v.move();
            if(movingRight){
                speed=rand.nextInt(speed_bound);
                w.pos.x=w.pos.x+speed;// if not working then increment in pl/pr also
            }else{
                speed=rand.nextInt(speed_bound);
                w.pos.x=w.pos.x-speed;// if not working then decrement in pl/pr also
            }
        }
    }

    //.....get screen width.........
    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    //..........get screen height.........
    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
