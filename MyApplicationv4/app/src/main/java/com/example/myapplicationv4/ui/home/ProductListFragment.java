package com.example.myapplicationv4.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationv4.Product;
import com.example.myapplicationv4.ProductAdapter;
import com.example.myapplicationv4.ProductFormActivity;
import com.example.myapplicationv4.R;
import com.example.myapplicationv4.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList = new ArrayList<>();
    private static final int REQUEST_CODE_ADD_PRODUCT = 1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home , container, false);

        Button addButton = view.findViewById(R.id.add_product_button);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);


        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ProductFormActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_PRODUCT);
        });

        return view;
    }

    public void addProduct(Product product) {
        productList.add(product);
        adapter.notifyDataSetChanged();
    }
}
