package com.example.anubhav.testcam;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        if(savedInstanceState==null){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new CameraFragment()).commit();
        }
    }
}
