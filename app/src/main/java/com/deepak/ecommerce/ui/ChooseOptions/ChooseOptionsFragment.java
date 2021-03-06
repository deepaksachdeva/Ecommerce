package com.deepak.ecommerce.ui.ChooseOptions;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.deepak.ecommerce.R;
import com.deepak.ecommerce.databinding.FragmentChooseOptionsBinding;
import com.deepak.ecommerce.models.ApiResponse;
import com.deepak.ecommerce.models.Product;
import com.deepak.ecommerce.ui.main.MainActivity;
import com.deepak.ecommerce.ui.products.ProductsFragment;
import com.deepak.ecommerce.ui.ranking.MostViewedAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ChooseOptionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseOptionsFragment extends Fragment implements View.OnClickListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ApiResponse apiResponse;
    private int mParam2;
    private MainActivity activity;
    private FragmentChooseOptionsBinding binding;

    public ChooseOptionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param apiResponse Parameter 1.
     * @param param2      Parameter 2.
     * @return A new instance of fragment ChooseOptionsFragment.
     */
    public static ChooseOptionsFragment newInstance(ApiResponse apiResponse, int param2) {
        ChooseOptionsFragment fragment = new ChooseOptionsFragment();
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

    private void ranking1Products() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity
                , LinearLayoutManager.HORIZONTAL, false);
        binding.rvMostViewed.setLayoutManager(mLayoutManager);
        binding.rvMostViewed.setItemAnimator(new DefaultItemAnimator());
        List<Product> listViewedProducts = new ArrayList<>();

        for (int i = 0; i < apiResponse.getCategories().size(); i++) {
            for (int j = 0; j < apiResponse.getCategories().get(i).getProducts().size(); j++) {
                for (int k = 0; k < apiResponse.getRankings().get(0).getProducts().size(); k++) {
                    if (apiResponse.getCategories().get(i).getProducts().get(j).getId()
                            .equals(apiResponse.getRankings().get(0).getProducts().get(k).getId())) {
//                        Product product = apiResponse.getCategories().get(i).getProducts().get(j);
//                        product.setViewCount(apiResponse.getRankings().get(0).getProducts().get(k).getViewCount());
                        listViewedProducts.add(apiResponse.getCategories().get(i).getProducts().get(j));
                        Log.i("check", "loop");
                        break;
                    }
                }
            }
        }

        if (listViewedProducts.size() != 0) {
            MostViewedAdapter mAdapter = new MostViewedAdapter(activity, listViewedProducts,
                    apiResponse.getRankings().get(0).getProducts(), 1);
            binding.rvMostViewed.setAdapter(mAdapter);
        }
    }

    private void ranking2Products() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity
                , LinearLayoutManager.HORIZONTAL, false);
        binding.rvMostOrdered.setLayoutManager(mLayoutManager);
        binding.rvMostOrdered.setItemAnimator(new DefaultItemAnimator());

        List<Product> listOrderedProducts = new ArrayList<>();

        for (int i = 0; i < apiResponse.getCategories().size(); i++) {
            for (int j = 0; j < apiResponse.getCategories().get(i).getProducts().size(); j++) {
                for (int k = 0; k < apiResponse.getRankings().get(1).getProducts().size(); k++) {
                    if (apiResponse.getCategories().get(i).getProducts().get(j).getId()
                            .equals(apiResponse.getRankings().get(1).getProducts().get(k).getId())) {
//                        Product product = apiResponse.getCategories().get(i).getProducts().get(j);
//                        product.setOrderCount(apiResponse.getRankings().get(1).getProducts().get(k).getOrderCount());
                        listOrderedProducts.add(apiResponse.getCategories().get(i).getProducts().get(j));
                        break;
                    }
                }
            }
        }

        if (listOrderedProducts.size() != 0) {
            MostViewedAdapter mAdapter = new MostViewedAdapter(activity, listOrderedProducts,
                    apiResponse.getRankings().get(1).getProducts(), 2);
            binding.rvMostOrdered.setAdapter(mAdapter);
        }
    }

    private void ranking3Products() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity
                , LinearLayoutManager.HORIZONTAL, false);
        binding.rvMostShared.setLayoutManager(mLayoutManager);
        binding.rvMostShared.setItemAnimator(new DefaultItemAnimator());
        List<Product> listSharedProducts = new ArrayList<>();

        for (int i = 0; i < apiResponse.getCategories().size(); i++) {
            for (int j = 0; j < apiResponse.getCategories().get(i).getProducts().size(); j++) {
                for (int k = 0; k < apiResponse.getRankings().get(2).getProducts().size(); k++) {
                    if (apiResponse.getCategories().get(i).getProducts().get(j).getId()
                            .equals(apiResponse.getRankings().get(2).getProducts().get(k).getId())) {
//                        Product product = apiResponse.getCategories().get(i).getProducts().get(j);
//                        product.setShares(apiResponse.getRankings().get(2).getProducts().get(k).getShares());
                        listSharedProducts.add(apiResponse.getCategories().get(i).getProducts().get(j));
                        break;
                    }
                }
            }
        }

        if (listSharedProducts.size() != 0) {
            MostViewedAdapter mAdapter = new MostViewedAdapter(activity, listSharedProducts,
                    apiResponse.getRankings().get(2).getProducts(), 3);
            binding.rvMostShared.setAdapter(mAdapter);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_choose_options, container, false);

        activity.setUpActionBar(getString(R.string.choose_option));

        binding.tv1.setText(apiResponse.getRankings().get(0).getRanking());
        binding.tv2.setText(apiResponse.getRankings().get(1).getRanking());
        binding.tv3.setText(apiResponse.getRankings().get(2).getRanking());

        ranking1Products();
        ranking2Products();
        ranking3Products();

        binding.tvForAdults.setOnClickListener(this);
        binding.tvForKids.setOnClickListener(this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_for_adults:
                activity.replaceFragment(ProductsFragment.newInstance(apiResponse, mParam2));
                break;
            case R.id.tv_for_kids:
                Toast.makeText(activity, R.string.coming_soon, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}