package com.example.soundararajan.testopengl;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.HashMap;


public class MainActivity extends Activity {

    PlusListener plusListener;
    MinusListener minusListener;
    public MainActivity()
    {
        plusListener = new PlusListener();
        minusListener = new MinusListener();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        Display display = ((WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int screenRotation = display.getRotation();

        GLSurfaceView shotView = (GLSurfaceView) findViewById(R.id.shotView);
        MyRenderer renderer = new MyRenderer(this,screenRotation);
        shotView.setRenderer(renderer);

        RegisterMenuItemClickListener(R.id.xplus, true);
        RegisterMenuItemClickListener(R.id.xminus, false);

        RegisterMenuItemClickListener(R.id.yplus, true);
        RegisterMenuItemClickListener(R.id.yplus, false);

        RegisterMenuItemClickListener(R.id.zplus, true);
        RegisterMenuItemClickListener(R.id.zminus, false);

        RegisterMenuItemClickListener(R.id.rollplus, true);
        RegisterMenuItemClickListener(R.id.rollminus, false);

        RegisterMenuItemClickListener(R.id.yawplus, true);
        RegisterMenuItemClickListener(R.id.yawminus, false);

        RegisterMenuItemClickListener(R.id.pitchplus, true);
        RegisterMenuItemClickListener(R.id.pitchminus, false);

    }

    HashMap hm = new HashMap();

    void RegisterMenuItemClickListener(int id, boolean plus)
    {
        if(plus)
            findViewById(id).setOnClickListener(plusListener);
        else
            findViewById(id).setOnClickListener(minusListener);
        hm.put(id, 0.0f);
    }

    private class PlusListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int id = v.getId();
            float val = (float)hm.get(id);
            val +=1.0f;
            hm.put(id, val);
        }
    }

    private class MinusListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int id = v.getId();
            float val = (float)hm.get(id);
            val -=0.1f;
            hm.put(id, val);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
