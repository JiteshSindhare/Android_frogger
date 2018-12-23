package com.example.jitesh.newapptrial;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;

public class Vehicless extends ArrayList<vehicle> {

    public  final float step=190; // It is distance between vehicles
    public  int speed=5;    // speed is not used now, earlier it was used as speed with which vehicles move
    private Boolean movingRight; // movingRight is used as a direction if it should be used left or right

    /**
     * ........... To create Vehicles......
     */
    public  Vehicless road_vehicle(int dif){
       // float y=1000;
        float y=30;
        float x=0;
        int limit=0;
        /**
         * ...Initially diff was made to so that it can be used as a difficulty( which will pass from
         *  difficulty button from Welcome screen)..
          */

        if(dif==1){
            speed=5;
            limit =3;
        }else if(dif==2){
            speed=10;
            limit=5;
        }else{
            speed=15;
            limit=8;
        }

        Vehicless   veh=new Vehicless();
        for(int i=0;i<limit;i++){
            if(i%2==0 ){
                // this is to place vehicle on right side
                x=getScreenWidth()-100;
                veh.movingRight=false;
            }else{
                // this is to place vehicle on left side
                x=100;
                veh.movingRight=true;
            }

            veh.add(new vehicle(x,y));
            y=y+step;
            // step is distance between each vehicle
        }
        return veh;
    }

    /**
     * .........To draw vehicle as a rectangle.............
     */

    public void draw(Canvas canvas, Paint paint) {
        //Log.d("VEHICLE"," DRAWING VEHICLE " );
        for (vehicle v:this){ v.draw(canvas, paint);
        }
    }

    /**.......To draw vehicle image............
      */

    public void draw1(Canvas c, Paint p,Bitmap bm) {
     //   Log.d("VEHICLE"," inside drawing vehicle image " );
        for (vehicle v:this) v.draw1(c, p,bm);
    }

    /**
     * ............. For moving vehicles..........
     */

    public void step(){

       // Log.d("VEHICLES"," step " );
        for(vehicle v:this){
           // int m=v.move();
            if(v.pos.x<=0){
                v.pos.x=getScreenWidth()-100;
            }else if(v.pos.x>=getScreenWidth()){
                v.pos.x=0;
            }

            if(movingRight){
                v.pos.x=v.pos.x+speed;// if not working then increment in pl/pr also
             //   Log.d("VEHICLES"," TRUE moveRight step " +v.pos.x +" pox y"+v.pos.y);
            }else{

                v.pos.x=v.pos.x-speed;// if not working then increment in pl/pr also
             //   Log.d("VEHICLES","false MovingRIght pos.x " +v.pos.x+" speed "+speed +" pos y"+v.pos.y);
            }
        }
    }

    /**
     * .....get screen width.........
     */
    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**..........get screen height.........
     */
    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

}
