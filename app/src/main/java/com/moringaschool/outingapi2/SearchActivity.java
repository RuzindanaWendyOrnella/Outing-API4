package com.moringaschool.outingapi2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.EditSearchText) EditText mEditSearchText;
    @BindView(R.id.SubmitSearchButton) Button mSubmitSearchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        mSubmitSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mEditSearchText.getText().toString();
                Intent intent2 = new Intent(SearchActivity.this,ApiActivity.class);
                intent2.putExtra("location", location);
                startActivity(intent2);
            }

        });

    }
}
