package com.deepak.ecommerce.ui.products;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepak.ecommerce.R;
import com.deepak.ecommerce.databinding.ProductListRowBinding;
import com.deepak.ecommerce.models.ApiResponse;
import com.deepak.ecommerce.ui.variants.VariantsAdapter;

/**
 * To display list of search data
 * Created by deepak sachdeva on 14/08/17.
 * <p>
 * version 1.0
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> implements View.OnClickListener {

    private ApiResponse apiResponse;
    private Context context;
    private LayoutInflater layoutInflater;
    private int clickedPosition;

    public ProductAdapter(Context context, ApiResponse apiResponse, int clickedPosition) {
        this.apiResponse = apiResponse;
        this.context = context;
        this.clickedPosition = clickedPosition;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ProductListRowBinding productListRowBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.product_list_row, parent, false);

        return new ProductViewHolder(productListRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        if (apiResponse != null) {
            for (int i = 0; i < apiResponse.getCategories().get(clickedPosition).getProducts().size(); i++) {
                holder.productListRowBinding.setProduct(apiResponse.getCategories().get(clickedPosition).getProducts().get(position));
            }
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context,
                    LinearLayoutManager.HORIZONTAL, false);
            holder.productListRowBinding.rvVariants.setLayoutManager(mLayoutManager);
            holder.productListRowBinding.rvVariants.setItemAnimator(new DefaultItemAnimator());

            VariantsAdapter mAdapter = new VariantsAdapter(
                    apiResponse.getCategories().get(clickedPosition).getProducts().get(position).getVariants());
            holder.productListRowBinding.rvVariants.setAdapter(mAdapter);

            holder.productListRowBinding.linParent.setOnClickListener(this);
        }
    }

    @Override
    public int getItemCount() {
        return apiResponse.getCategories().get(clickedPosition).getProducts().size();
    }

    @Override
    public void onClick(View view) {

    }
}