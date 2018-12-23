package com.example.jitesh.newapptrial;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Base for drawing
 */
public abstract class sprite {
    pos pos;

    public abstract void draw(Canvas c, Paint p);
}
