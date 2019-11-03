package com.moringaschool.outingapi2;
import android.Manifest;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.getExternalStoragePublicDirectory;

/*
package com.moringaschool.outingapi2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
public class SavedActivity extends AppCompatActivity {
    @BindView (R.id.locationNameText) TextView mlocationNameText;
    @BindView (R.id.locationTypeText) TextView mlocationTypeText;
    @BindView (R.id.locationDescriptionText) TextView mlocationDescriptionText;
    @BindView (R.id.locationDressCodeText) TextView mlocationDresscodeText;
    @BindView (R.id.locationTimeText) TextView mlocationTimeText;
private Context context;
private  SavedAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        ButterKnife.bind(this);

   */
/*     SavedAdapter adapter=new SavedAdapter(this,android.R.layout.simple_list_item_1,mlist,mlocationNameText,mlocationTypeText,mlocationDescriptionText,mlocationDresscodeText,mlocationTimeText,context);*//*

     */
/*  SavedAdapter adapter=new SavedAdapter()*//*

        Intent intent2 = getIntent();
        String Name = intent2.getStringExtra("Name");
        System.out.println(Name);
        String Type = intent2.getStringExtra("Type");
        String Description = intent2.getStringExtra("Description");
        String Dresscode = intent2.getStringExtra("Dresscode");
        String Time = intent2.getStringExtra("Time");
        mlocationNameText.setText(  "NAME: " + Name);
        mlocationTypeText.setText(  "TYPE: " + Type);
        mlocationDescriptionText.setText(  "DESCRIPTION: " + Description);
        mlocationDresscodeText.setText("DRESSCODE: " +  Dresscode);
        mlocationTimeText.setText(  "TIME: " + Time);
        Toast.makeText(SavedActivity.this, "Congratulations,your Event Has Been Saved!", Toast.LENGTH_LONG).show();
    }
}
*/
/*Reference:Android Studio Tutorial By The Code City*/

public class SavedActivity extends AppCompatActivity {
    Button btnTakePic;
    ImageView imageView;
    String pathToFile;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private int mOrientation;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        btnTakePic=findViewById(R.id.btnTakePic);
        if (Build.VERSION.SDK_INT>=23){
            requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},2);
        }

        btnTakePic.setOnClickListener(new View.OnClickListener() {
            /*Added property setOnClickListener so that when the user clicks on the button they take a picture*/
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });
        imageView =findViewById(R.id.image);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*if (requestCode == RESULT_OK){
            if (requestCode ==1 ){
             Bitmap bitmap= BitmapFactory.decodeFile(pathToFile);
             imageView.setImageBitmap(bitmap);
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imageView.setImageBitmap(imageBitmap);

            }
        }*/
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap bitmap= BitmapFactory.decodeFile(pathToFile);
            imageView.setImageBitmap(bitmap);
        }

    }

/*property newConfig will help us to know if we are in portait or landscap mode*/
   @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(getApplicationContext(), "Portrait mode", Toast.LENGTH_SHORT).show();
        }else  if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getApplicationContext(), "Landscape mode", Toast.LENGTH_SHORT).show();
        }
    }

    private void takePicture() {
        Intent takeSnap=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takeSnap.resolveActivity(getPackageManager())!=null){
            File picFile=null;
             picFile=createPicFile();
         if (picFile !=null){
            pathToFile=picFile.getAbsolutePath();
             Uri pictureURL= FileProvider.getUriForFile(SavedActivity.this,"com.moringaschool.outingapi2.FileProvider",picFile);
             takeSnap.putExtra(MediaStore.EXTRA_OUTPUT,pictureURL);
             startActivityForResult(takeSnap,1);
         }

        }
    }

    private File createPicFile() {
        String name=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File dir=getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image=null;
        try {
            image=File.createTempFile(name,".jpg",dir);
        } catch (IOException e) {
            Log.d("myLog","Excep:"+e.toString());
        }
        return image;
    }
    /*public void encodeBitmapAndSaveToFirebase(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        String imageEncoded = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference(Constants.FIREBASE_CHILD_RESTAURANTS)
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child(mRestaurant.getPushId())
                .child("imageUrl");
        ref.setValue(imageEncoded);
    }*/
}