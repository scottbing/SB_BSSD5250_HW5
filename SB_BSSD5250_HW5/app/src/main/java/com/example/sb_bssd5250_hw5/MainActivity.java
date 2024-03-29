package com.example.sb_bssd5250_hw5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        /*RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(View.generateViewId());

        NoteFragment noteFragment = new NoteFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(relativeLayout.getId(), noteFragment);
        fragmentTransaction.commit();*/

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setId(View.generateViewId());

        NoteFragment noteFragment = new NoteFragment();
        NoteFragment noteFragment2 = new NoteFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(linearLayout.getId(), noteFragment);
        fragmentTransaction.add(linearLayout.getId(), noteFragment2);
        fragmentTransaction.commit();

        setContentView(linearLayout);
    }
}
