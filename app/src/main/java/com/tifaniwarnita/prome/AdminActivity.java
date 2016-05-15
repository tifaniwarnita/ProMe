package com.tifaniwarnita.prome;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    private static final int SELECT_PICTURE = 0;
    private ImageButton buttonUploadImage;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button buttonSubmit = (Button) findViewById(R.id.button_submit);
        buttonUploadImage = (ImageButton) findViewById(R.id.image_upload_button);
        final EditText promoTitle = (EditText) findViewById(R.id.activity_admin_promo_title);
        final EditText promoPeriod = (EditText) findViewById(R.id.activity_admin_period);
        final Spinner promoCategory = (Spinner) findViewById(R.id.spinner_category);

        final AdminActivity activity = this;
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = promoTitle.getText().toString();
                String period = promoPeriod.getText().toString();
                String category = promoCategory.getSelectedItem().toString();
                PromoList.addPromo(new Promo(title, period, category, bitmap));
                Log.d(AdminActivity.class.getSimpleName(), "Add new promo: " + title + " " + period + " " + category);
                Toast.makeText(activity, "Your promo has been published", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdminActivity.this, PromoActivity.class);
                intent.putExtra(PromoActivity.ADDED, PromoActivity.ADDED);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        buttonUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Select Picture"), SELECT_PICTURE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            bitmap = getPath(data.getData());
            buttonUploadImage.setImageBitmap(bitmap);
        }
    }

    private Bitmap getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String filePath = cursor.getString(column_index);
        cursor.close();
        // Convert file path into bitmap image using below line.
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        cursor.close();
        return bitmap;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
