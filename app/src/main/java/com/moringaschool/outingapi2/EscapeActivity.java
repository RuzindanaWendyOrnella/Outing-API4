package com.moringaschool.outingapi2;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
public class EscapeActivity extends AppCompatActivity {
    @BindView(R.id.eventButton)
    Button mEventButton;
    @BindView(R.id.searchButton)
    Button mSearchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escape);
        ButterKnife.bind(this);
        mEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(EscapeActivity.this, SavedActivity.class);
                startActivity(intent1);
            }

        });
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(EscapeActivity.this, SearchActivity.class);
                startActivity(intent1);
            }

        });
    }

}