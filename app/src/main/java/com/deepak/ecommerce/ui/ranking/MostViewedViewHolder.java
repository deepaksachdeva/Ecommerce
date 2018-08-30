package com.deepak.ecommerce.ui.ranking;

import android.support.v7.widget.RecyclerView;

import com.deepak.ecommerce.databinding.MostViewedListRowBinding;
import com.deepak.ecommerce.databinding.ProductListRowBinding;


/**
 * View holder of searched data
 * Created by deepak sachdeva on 14/08/17.
 *
 * version 1.0
 */

public class MostViewedViewHolder extends RecyclerView.ViewHolder {

    public MostViewedListRowBinding productListRowBinding;

    public MostViewedViewHolder(MostViewedListRowBinding productListRowBinding) {
        super(productListRowBinding.getRoot());
        this.productListRowBinding = productListRowBinding;
    }
}
