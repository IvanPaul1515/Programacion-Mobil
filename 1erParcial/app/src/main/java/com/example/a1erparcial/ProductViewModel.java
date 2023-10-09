package com.example.a1erparcial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a1erparcial.api.ProductService;
import com.example.a1erparcial.entity.Product;
import com.example.a1erparcial.api.RetrofitClient;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModel extends ViewModel {
    private ProductService productService;
    private MutableLiveData<List<Product>> productListLiveData;
    private MutableLiveData<Product> selectedProductLiveData;

    public ProductViewModel() {
        productService = RetrofitClient.create(ProductService.class);
        productListLiveData = new MutableLiveData<>();
        selectedProductLiveData = new MutableLiveData<>();
        loadProducts();
    }

    public LiveData<List<Product>> getProductListLiveData() {
        return productListLiveData;
    }

    public LiveData<Product> getSelectedProductLiveData() {
        return selectedProductLiveData;
    }

    public void loadProducts() {
        Call<List<Product>> call = productService.getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    productListLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }

    public void loadProductDetails(int productId) {
        Call<Product> call = productService.getProductDetails(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful() && response.body() != null) {
                    selectedProductLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
            }
        });
    }

    public void searchProducts(String query) {
        Call<List<Product>> call = productService.searchProducts(query);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    productListLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }
}
