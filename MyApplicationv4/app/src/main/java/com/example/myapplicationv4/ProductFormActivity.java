package com.example.myapplicationv4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductFormActivity extends AppCompatActivity {

    private EditText nameEditText, descriptionEditText, priceEditText, stockEditText;
    private ImageView productImageView;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_form);

        nameEditText = findViewById(R.id.name_edit_text);
        descriptionEditText = findViewById(R.id.description_edit_text);
        priceEditText = findViewById(R.id.price_edit_text);
        stockEditText = findViewById(R.id.stock_edit_text);
        productImageView = findViewById(R.id.product_image);

        Button selectImageButton = findViewById(R.id.select_image_button);
        selectImageButton.setOnClickListener(v -> selectImage());

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(v -> saveProduct());
    }

    private void selectImage() {
        // Código para seleccionar una imagen
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            productImageView.setImageURI(imageUri);
        }
    }

    private void saveProduct() {
        String name = nameEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        double price = Double.parseDouble(priceEditText.getText().toString());
        int stock = Integer.parseInt(stockEditText.getText().toString());

        Product product = new Product(name, description, price, stock, imageUri);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("product", product);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
