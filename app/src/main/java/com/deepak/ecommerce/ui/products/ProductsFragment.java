package com.deepak.ecommerce.ui.products;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepak.ecommerce.R;
import com.deepak.ecommerce.databinding.FragmentProductsBinding;
import com.deepak.ecommerce.models.ApiResponse;
import com.deepak.ecommerce.ui.main.MainActivity;
import com.deepak.ecommerce.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ProductsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductsFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ApiResponse apiResponse;
    private int mParam2;
    private MainActivity activity;
    private FragmentProductsBinding binding;

    public ProductsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param apiResponse Parameter 1.
     * @param param2      Parameter 2.
     * @return A new instance of fragment ProductsFragment.
     */
    public static ProductsFragment newInstance(ApiResponse apiResponse, int param2) {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, apiResponse);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            apiResponse = (ApiResponse) getArguments().getSerializable(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    private void setVisibility(int recycler, int textView, String txt) {
        binding.rvProducts.setVisibility(recycler);
        binding.linSearchTxt.setVisibility(textView);
        binding.tvMessage.setText(txt);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false);
        activity.setUpActionBar(getString(R.string.products));

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        binding.rvProducts.setLayoutManager(mLayoutManager);
        binding.rvProducts.setItemAnimator(new DefaultItemAnimator());

        if (apiResponse.getCategories().get(mParam2).getProducts().size() != 0) {
            setVisibility(View.VISIBLE, View.GONE, Constants.BLANK);
            ProductAdapter mAdapter = new ProductAdapter(activity, apiResponse, mParam2);
            binding.rvProducts.setAdapter(mAdapter);
        } else {
            setVisibility(View.GONE, View.GONE, getString(R.string.no_data_found));
        }

        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }
}