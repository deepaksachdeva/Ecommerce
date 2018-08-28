package com.deepak.ecommerce.ui.main;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.deepak.ecommerce.R;
import com.deepak.ecommerce.databinding.CategoryListRowBinding;
import com.deepak.ecommerce.models.ApiResponse;
import com.deepak.ecommerce.ui.ChooseOptions.ChooseOptionsFragment;
import com.deepak.ecommerce.utils.Constants;

/**
 * To display list of search data
 * Created by deepak sachdeva on 14/08/17.
 *
 * version 1.0
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> implements View.OnClickListener {

    private ApiResponse apiResponse;
    private Context context;
    private LayoutInflater layoutInflater;

    CategoriesAdapter(Context context, ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CategoryListRowBinding categoryListRowBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.category_list_row, parent, false);

        return new CategoryViewHolder(categoryListRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        if (apiResponse != null) {
            holder.movieListRowBinding.setApiResponse(apiResponse);

            for(int i = 0; i< apiResponse.getCategories().size(); i++){
                holder.movieListRowBinding.setCategory(apiResponse.getCategories().get(position));
            }

            holder.movieListRowBinding.linParent.setOnClickListener(this);
        }
    }

    @BindingAdapter({Constants.MOVIE_POSTER})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    @Override
    public int getItemCount() {
        return apiResponse.getCategories().size();

    }

    @Override
    public void onClick(View view) {
        ((MainActivity)context).replaceFragment(ChooseOptionsFragment.newInstance(apiResponse,""));
    }
}