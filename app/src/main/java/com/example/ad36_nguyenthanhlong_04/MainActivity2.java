package com.example.ad36_nguyenthanhlong_04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity implements IonclickContact {
    String Tag = "MainActivity";
    BottomNavigationView bottomNavigationView;
    Contact contact;
    TextView tvUsername;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main2);


        bottomNavigationView = findViewById(R.id.nav);
        tvUsername = findViewById(R.id.tvNameUser);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tvUsername.setText("Welcome: " + name);



        getFragment(Oder_Fragment.newInstance());
        //getFragment(Detail_Fragment.newInstance(contact));

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.mnHome:
                        getFragment(Oder_Fragment.newInstance());
                        break;
                    case R.id.mnDetail:
                        getFragment(Detail_Fragment.newInstance(contact, count));
                        break;
                }
                return false;
            }
        });


    }


    public void getFragment(Fragment fragment) {
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(Tag, "getFragment: " + e.getMessage());
        }
    }


    @Override
    public void onClickDrink(Contact contact) {
        this.contact=contact;

        count = count+1;


    }


}
