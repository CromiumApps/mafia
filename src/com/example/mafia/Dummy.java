package com.example.mafia;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Dummy extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_dummy, menu);
        return true;
    }
}
