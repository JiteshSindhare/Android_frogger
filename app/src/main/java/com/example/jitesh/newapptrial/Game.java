package com.example.jitesh.newapptrial;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;

public class Game {

    static final int diff=1;

    private Vehicless veh;
    private wood_planks wd_pl;
    private frog frg;



    static final int step_length=90;// It is length with which frog  moves with every click


    private boolean frog_hit; // ......... IT stores value if frog is hit........
    private boolean on_plank;//.........IT stores value if plank...........
    private boolean on_sea;
    private boolean frog_clicked;

/**
 * ....... Creating/Initializing frog, Vehicles and Wood planks
 */
    public Game(){
        veh=new Vehicless();
        wd_pl=new wood_planks();
        frg=new frog();

        veh= veh.road_vehicle(diff);

        wd_pl=wd_pl.river_plank(diff);

    }

    /**
     * .....TO call drawing method of Frog, Vehicles and Wood_Plank....Which is not using now.....
     */
    public void draw(Canvas canvas, Paint paint){

        veh.draw(canvas,paint);
        wd_pl.draw(canvas,paint);
        frg.draw(canvas,paint);
    }

    /**
     * .....TO call drawing image method of Frog, Vehicles and Wood_Plank........
     */
    public void draw(Canvas canvas, Paint paint,Bitmap bm){
        frg.draw(canvas,paint,bm);

    }

 /**.......check if Frog is on sea......
  */
public boolean on_sea(){
        //Log.d("Game"," frog pos x "+frg.pos.x+" frog pos y "+frg.pos.y);
    //Log.d("Game","value of Screen height "+(getScreenHeight()-frg.pos.y)+"difference is "+ (getScreenHeight()-771) );
    //if(frg.pos.y>=(getScreenHeight()-780) && frg.pos.y<=(getScreenHeight()-284) ){
    if(frg.pos.y<=(780) && frg.pos.y>=(330) ){
        Log.d("SEA/GAME"," on sea "+" gettingscreen height is "+(getScreenHeight()-frg.pos.y));
        Log.d("Game"," frog pos y "+frg.pos.y);
        return on_sea=true;

    }else{
      //  Log.d("SEA/GAME"," on sea");
      return  on_sea=false;
    }
    //return on_sea;
}
    /**
     * .......Calling drawing image method of vehicle
     */
    public void drawv(Canvas canvas, Paint paint,Bitmap bm){
        //Log.d("GAME"," SIZE vehicle"+veh.size() ); it was 3 now
        veh.draw1(canvas,paint,bm); // to draw wood logs images of cars
    }

    /**
     * ..........Calling drawing image method of vehicle
     */
    public void draww(Canvas canvas, Paint paint,Bitmap bm){
        //Log.d("Game"," Inside drawing wood plank " );
       // Log.d("GAME"," SIZE WOODPLANK "+wd_pl.size() ); it was 3 now

        wd_pl.draw1(canvas,paint,bm);// to draw wood logs images
    }

    /**
     * .....Calling step method of Vehicle and Wood-Plank which makes them move
     */
    public void step(){

        veh.step();
        wd_pl.step();

//        Log.d("Position of frog","pos x "+frg.pos.x+" pos y"+frg.pos.y);

        /**
         * .......Checking if frog hit by vehicle...........
         */
        for(vehicle v: veh){
 //           Log.d("Position of Vehicle","pos x "+v.pos.x+" pos y"+v.pos.y);
            if(frg.hitBy(v)){
                frog_hit=true;
                break; // so that it stops after getting value
            }else{
                frog_hit=false;
            }
        }
/**
 * ...........CHecking if frog is hit by wood plank.........
 */
        for(wood_plank w: wd_pl){
            //Log.d("Position of Vehicle","pos x "+w.pos.x+" pos y"+w.pos.y);
            if(frg.hitBy(w) ){  //&& !frog_clicked
                //frog_hit=true;
                //on_plank=true;
            }else{
                // frog_hit=false;
               // on_plank=false;
            }
        }
    }

    /**
     * ...........CHecking if frog is on plank..........
     */
    public boolean on_plank(){
        for(wood_plank w: wd_pl){

            if(frg.hitBy(w) && on_sea() ){ //&& !frog_clicked
                //frog_hit=true;
                Log.d("Pos of PLANK","pos x "+w.pos.x+" pos y"+w.pos.y+" pos of frog "+ frg.pos.y);
               return on_plank=true;
            }else{
                // frog_hit=false;
              return  on_plank=false;
            }
        }
        return on_plank;
    }

    /**
     * THIS code is responsible for moving FROG UPSIDE,DOWNSIDE, RIGHT,LEFT.
    **/
    public void touch(MotionEvent me){

        int center_x=getScreenWidth()/2;
        int center_y=getScreenHeight()/2;

        float touch_x=me.getX();
        float touch_y=me.getY();
        //Log.d("Game","value of touch_x "+touch_x+" value of touch_y"+touch_y );
   //     Log.d("Game","value of Screen height "+getScreenHeight()+" screen width"+getScreenWidth() );

     //   Log.d("Game","value of frog x "+frg.pos.x+" value of frog y"+frg.pos.y );
       /**
        * TO move frog UPWARD
        */
        if((touch_x-center_x<=150 && touch_x-center_x>=0) && center_y-touch_y>150&& frg.pos.y>=35){
            //   moving=false;
           // frogPosy-=35;  // MOVING upwards

            frg.pos.y=frg.pos.y - step_length;
            //frog_clicked=true;
        }
        /**
         * TO move frog RIGHT
         */
        if(touch_x-center_x>150 && (center_y-touch_x<=150 && center_y-touch_x>=0) && frg.pos.x<=(getScreenWidth()-180)){
            //   moving=false;
            //frogPosx+=35; // MOVING right
           // frog_clicked=true;
            frg.pos.x=frg.pos.x + step_length;
        }
        /**
         * TO move frog DOWN
         *      and
         *      else if part is for moving frog Left
         */
        if((touch_x-center_x<=150 && touch_x-center_x>=0) && touch_y-center_y>=150 && frg.pos.y<=(getScreenHeight()-300)){
            //    moving=false;
            //frogPosy+=35; // MOVING down
           // frog_clicked=true;
            frg.pos.y=frg.pos.y + step_length;
        }else if((center_x-touch_x>=150) && (center_y-touch_y<=150 && center_y-touch_y>=0) && frg.pos.x>=35){
            //   moving=false;
            //frogPosx-=35;  // MOVING left
            frg.pos.x=frg.pos.x - step_length;
            //frog_clicked=true;
        }
        //this.step();
        //return true;

    }

    /**
     * @return true if game_over is true then game_over image is revoked
     */
    public boolean game_over(){
        on_sea();
        boolean t=on_plank();
        if(frog_hit){ // ||(on_sea && !on_plank)
            Log.d("Game","OVER is switched "+(getScreenHeight()-frg.pos.y)+"" );
            return true;
        }
        return false;
    }

    /**
     * @return width of screen not canvas
     */
    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * @return Height of screen not canvas
     */
    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

}
