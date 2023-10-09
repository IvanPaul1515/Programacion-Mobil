package com.example.a1erparcial;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class ProductDetailActivity extends AppCompatActivity {
    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        TextView productTitleTextView = findViewById(R.id.titulo);
        TextView productDescriptionTextView = findViewById(R.id.descripcion);

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        productViewModel.getSelectedProductLiveData().observe(this, product -> {
            productTitleTextView.setText(product.getTitle());
            productDescriptionTextView.setText(product.getDescription());
        });

        int productId = getIntent().getIntExtra("productId", -1);
        if (productId != -1) {
            productViewModel.loadProductDetails(productId);
        }
    }
}
