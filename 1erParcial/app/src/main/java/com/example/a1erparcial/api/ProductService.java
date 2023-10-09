package com.example.a1erparcial.api;

import com.example.a1erparcial.entity.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductService {
    @GET("products")
    Call<List<Product>> getProducts();

    @GET("products/{productId}")
    Call<Product> getProductDetails(@Path("productId") int productId);

    @GET("products/search")
    Call<List<Product>> searchProducts(@Query("q") String query);
}
