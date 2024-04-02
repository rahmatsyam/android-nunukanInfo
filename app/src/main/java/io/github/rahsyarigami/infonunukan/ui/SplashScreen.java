package io.github.rahsyarigami.infonunukan.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.github.rahsyarigami.infonunukan.ui.main.MainActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Fabric.with(this, new Crashlytics());

        //Start home activity
//        startActivity(new Intent(SplashScreen.this, MainActivity.class));
        startActivity(new Intent(SplashScreen.this, MainActivity.class));
        //close splashscreen
        finish();

    }
}
