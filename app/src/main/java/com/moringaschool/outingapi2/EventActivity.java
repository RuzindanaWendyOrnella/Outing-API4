package com.moringaschool.outingapi2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
public class EventActivity extends AppCompatActivity {
    @BindView(R.id.locationNameText) EditText mlocationNameText;
    @BindView (R.id.locationTypeText)EditText mlocationTypeText;
    @BindView (R.id.locationDescriptionText)EditText mlocationDescriptionText;
    @BindView (R.id.locationDressCodeText)EditText mlocationDresscodeText;
    @BindView (R.id.locationTimeText)EditText mlocationTimeText;
    @BindView (R.id.SubmitButton)Button mSubmitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ButterKnife.bind(this);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = mlocationNameText.getText().toString();
                String Type = mlocationTypeText.getText().toString();
                String Description = mlocationDescriptionText.getText().toString();
                String Dresscode = mlocationDresscodeText.getText().toString();
                String Time = mlocationTimeText.getText().toString();
                Intent intent2 = new Intent(EventActivity.this,SavedActivity.class);
                intent2.putExtra("Name", Name);
                intent2.putExtra("Type", Type);
                intent2.putExtra("Description", Description);
                intent2.putExtra("Dresscode", Dresscode);
                intent2.putExtra("Time", Time);
                startActivity(intent2);

            }
        });
    }

}
