package com.deepak.ecommerce.ui.variants;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.deepak.ecommerce.R;
import com.deepak.ecommerce.databinding.VariantListRowBinding;
import com.deepak.ecommerce.models.Variant;
import java.util.List;

/**
 * To display list of search data
 * Created by deepak sachdeva on 14/08/17.
 *
 * version 1.0
 */
public class VariantsAdapter extends RecyclerView.Adapter<VariantViewHolder> implements View.OnClickListener {

    private List<Variant> listVariant;
    private LayoutInflater layoutInflater;

    public VariantsAdapter(List<Variant> listVariant) {
        this.listVariant = listVariant;
    }

    @NonNull
    @Override
    public VariantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        VariantListRowBinding variantListRowBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.variant_list_row, parent, false);

        return new VariantViewHolder(variantListRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull VariantViewHolder holder, int position) {
        if (listVariant != null) {
            holder.variantListRowBinding.setVariant(listVariant.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return listVariant.size();
    }

    @Override
    public void onClick(View view) {
    }
}