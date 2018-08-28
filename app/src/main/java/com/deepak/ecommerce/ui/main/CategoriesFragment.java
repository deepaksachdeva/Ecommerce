package com.deepak.ecommerce.ui.main;

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
import com.deepak.ecommerce.databinding.FragmentCategoryBinding;
import com.deepak.ecommerce.listeners.IResponseListener;
import com.deepak.ecommerce.models.ApiResponse;
import com.deepak.ecommerce.network.NetworkController;
import com.deepak.ecommerce.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link CategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriesFragment extends Fragment implements IResponseListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private MainActivity activity;
    private FragmentCategoryBinding fragmentCategoryBinding;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoriesFragment.
     */
    public static CategoriesFragment newInstance(String param1, String param2) {
        CategoriesFragment fragment = new CategoriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCategoryBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false);

        NetworkController networkController = new NetworkController();
        networkController.getProducts(this, "", Constants.API_KEY);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        fragmentCategoryBinding.rvMovies.setLayoutManager(mLayoutManager);
        fragmentCategoryBinding.rvMovies.setItemAnimator(new DefaultItemAnimator());

        return fragmentCategoryBinding.getRoot();
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

    private void setVisibility(int recycler, int textView, String txt) {
        fragmentCategoryBinding.rvMovies.setVisibility(recycler);
        fragmentCategoryBinding.linSearchTxt.setVisibility(textView);
        fragmentCategoryBinding.tvMessage.setText(txt);
    }

    @Override
    public void onResponse(ApiResponse apiResponse) {
        if (apiResponse.getCategories() != null) {
            setVisibility(View.VISIBLE, View.GONE, "");
            CategoriesAdapter mAdapter = new CategoriesAdapter(activity, apiResponse);
            fragmentCategoryBinding.rvMovies.setAdapter(mAdapter);
        } else {
            setVisibility(View.GONE, View.VISIBLE, "Some server Error");
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        throwable.printStackTrace();
    }
}
