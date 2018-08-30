package com.deepak.ecommerce.ui.ranking;

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
import com.deepak.ecommerce.databinding.MostViewedListRowBinding;
import com.deepak.ecommerce.models.Product;
import com.deepak.ecommerce.models.Product_;
import com.deepak.ecommerce.ui.main.MainActivity;
import com.deepak.ecommerce.ui.variants.VariantsAdapter;
import com.deepak.ecommerce.ui.variants.VariantsFragment;

import java.util.List;

/**
 * To display list of search data
 * Created by deepak sachdeva on 14/08/17.
 * <p>
 * version 1.0
 */
public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedViewHolder> implements View.OnClickListener {

    private List<Product> listProducts;
    private List<Product_> listProducts_;
    private Context context;
    private LayoutInflater layoutInflater;
    private int option;

    public MostViewedAdapter(Context context, List<Product> listProducts, List<Product_> listProducts_, int option) {
        this.listProducts = listProducts;
        this.context = context;
        this.listProducts_ = listProducts_;
        this.option = option;
    }

    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        MostViewedListRowBinding mostViewedListRowBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.most_viewed_list_row, parent, false);

        return new MostViewedViewHolder(mostViewedListRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {
        if (listProducts != null) {
            for (int i = 0; i < listProducts.size(); i++) {
                holder.productListRowBinding.setProduct(listProducts.get(position));
            }


            if(option == 1) {
                holder.productListRowBinding.tvViewCount.setVisibility(View.VISIBLE);
                holder.productListRowBinding.tvOrderCount.setVisibility(View.GONE);
                holder.productListRowBinding.tvShares.setVisibility(View.GONE);
            }else if(option == 2){
                holder.productListRowBinding.tvViewCount.setVisibility(View.GONE);
                holder.productListRowBinding.tvOrderCount.setVisibility(View.VISIBLE);
                holder.productListRowBinding.tvShares.setVisibility(View.GONE);
            } else if(option == 3){
                holder.productListRowBinding.tvViewCount.setVisibility(View.GONE);
                holder.productListRowBinding.tvOrderCount.setVisibility(View.GONE);
                holder.productListRowBinding.tvShares.setVisibility(View.VISIBLE);
            }
            holder.productListRowBinding.linParent.setTag(R.integer.selected_index, position);
            holder.productListRowBinding.linParent.setOnClickListener(this);
        }

        if (listProducts_ != null) {
            holder.productListRowBinding.setProductRank(listProducts_.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    @Override
    public void onClick(View view) {
        int selectedIndex = (int) view.getTag(R.integer.selected_index);
        ((MainActivity) context).replaceFragment(VariantsFragment.newInstance(listProducts.get(selectedIndex).getVariants(), selectedIndex));

    }
}