

package com.example.soundararajan.testopengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class MyRenderer implements GLSurfaceView.Renderer {

    Line line;
    MainActivity parent;
    int screenRotation;

    float x,y,z,roll,pitch,yaw;
    public MyRenderer(MainActivity activity, int screenRotation) {
        this.parent = activity;
        this.screenRotation = screenRotation;
        line = new Line();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if(height == 0) {
            height = 1;
        }
        gl.glClearColor(1.0f,1.0f,1.0f,0.5f);
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glFrustumf(-(float)width/height, (float)width/height, -1, 1, 1, 500);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    synchronized void setX(float val){ this.x = val;}
    synchronized void setY(float val){ this.y = val;}
    synchronized void setZ(float val){ this.z = val;}
    synchronized void setRoll(float val){ this.roll = val;}
    synchronized void setPitch(float val){ this.pitch = val;}
    synchronized void setYaw(float val){ this.yaw = val;}

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_DEPTH_BUFFER_BIT | GL10.GL_COLOR_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glTranslatef(x,y,z);
        gl.glRotatef(0.0f, roll, pitch,yaw);
        line.draw(gl);
    }
}
