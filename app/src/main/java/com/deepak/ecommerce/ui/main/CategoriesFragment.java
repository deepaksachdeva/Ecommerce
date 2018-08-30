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
    private MainActivity activity;
    private FragmentCategoryBinding fragmentCategoryBinding;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CategoriesFragment.
     */
    public static CategoriesFragment newInstance() {
        return new CategoriesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    private void setVisibility(int recycler, int progress, int textView, String txt) {
        fragmentCategoryBinding.rvMovies.setVisibility(recycler);
        fragmentCategoryBinding.linProgress.setVisibility(progress);
        fragmentCategoryBinding.linSearchTxt.setVisibility(textView);
        fragmentCategoryBinding.tvMessage.setText(txt);
    }

    @Override
    public void onResponse(ApiResponse apiResponse) {
        if (apiResponse != null) {
            if (apiResponse.getCategories().size() != 0) {
                setVisibility(View.VISIBLE, View.GONE, View.GONE, "");
                CategoriesAdapter mAdapter = new CategoriesAdapter(activity, apiResponse);
                fragmentCategoryBinding.rvMovies.setAdapter(mAdapter);
            } else {
                setVisibility(View.GONE, View.GONE, View.VISIBLE, getString(R.string.no_data_found));
            }
        } else {
            setVisibility(View.GONE, View.GONE, View.VISIBLE, getString(R.string.server_error));
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        throwable.printStackTrace();
    }
}
