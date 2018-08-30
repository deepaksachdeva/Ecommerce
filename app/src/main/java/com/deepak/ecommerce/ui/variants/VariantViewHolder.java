package com.deepak.ecommerce.ui.variants;

import android.support.v7.widget.RecyclerView;

import com.deepak.ecommerce.databinding.ProductListRowBinding;
import com.deepak.ecommerce.databinding.VariantListRowBinding;


/**
 * View holder of searched data
 * Created by deepak sachdeva on 14/08/17.
 *
 * version 1.0
 */

public class VariantViewHolder extends RecyclerView.ViewHolder {

    public VariantListRowBinding variantListRowBinding;

    VariantViewHolder(VariantListRowBinding variantListRowBinding) {
        super(variantListRowBinding.getRoot());
        this.variantListRowBinding = variantListRowBinding;
    }
}
