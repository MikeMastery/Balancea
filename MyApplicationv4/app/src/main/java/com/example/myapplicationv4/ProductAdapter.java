package com.example.myapplicationv4;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;
    private Context context;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.nameTextView.setText(product.getName());
        holder.descriptionTextView.setText(product.getDescription());
        holder.priceTextView.setText(String.format("$%.2f", product.getPrice()));
        holder.stockTextView.setText(String.format("%d", product.getStock()));

        if (product.getImageUri() != null) {
            // Usa Glide para cargar la imagen de manera eficiente
            Glide.with(context)
                    .load(product.getImageUri())
                    .apply(new RequestOptions().placeholder(R.drawable.placeholder))
                    .into(holder.productImageView);
        } else {
            holder.productImageView.setImageResource(R.drawable.placeholder); // Imagen por defecto si no hay imagen
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView, descriptionTextView, priceTextView, stockTextView;
        ImageView productImageView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.product_name);
            descriptionTextView = itemView.findViewById(R.id.product_description);
            priceTextView = itemView.findViewById(R.id.product_price);
            stockTextView = itemView.findViewById(R.id.product_stock);
            productImageView = itemView.findViewById(R.id.product_image);
        }
    }
}
