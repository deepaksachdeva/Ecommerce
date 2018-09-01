package com.deepak.ecommerce.ui.products;

import android.support.v7.widget.RecyclerView;

import com.deepak.ecommerce.databinding.CategoryListRowBinding;
import com.deepak.ecommerce.databinding.ProductListRowBinding;


/**
 * View holder of searched data
 * Created by deepak sachdeva on 14/08/17.
 *
 * version 1.0
 */

public class ProductViewHolder extends RecyclerView.ViewHolder {

    public ProductListRowBinding productListRowBinding;

    ProductViewHolder(ProductListRowBinding productListRowBinding) {
        super(productListRowBinding.getRoot());
        this.productListRowBinding = productListRowBinding;
    }
}
