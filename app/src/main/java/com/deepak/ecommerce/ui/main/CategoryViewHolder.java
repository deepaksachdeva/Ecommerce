package com.deepak.ecommerce.ui.main;

import android.support.v7.widget.RecyclerView;
import com.deepak.ecommerce.databinding.CategoryListRowBinding;


/**
 * View holder of searched data
 * Created by deepak sachdeva on 14/08/17.
 *
 * version 1.0
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public CategoryListRowBinding movieListRowBinding;

    CategoryViewHolder(CategoryListRowBinding movieListRowBinding) {
        super(movieListRowBinding.getRoot());
        this.movieListRowBinding = movieListRowBinding;
    }
}
