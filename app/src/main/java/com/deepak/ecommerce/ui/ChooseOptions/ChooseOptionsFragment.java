package com.deepak.ecommerce.ui.ChooseOptions;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepak.ecommerce.R;
import com.deepak.ecommerce.databinding.FragmentChooseOptionsBinding;
import com.deepak.ecommerce.models.ApiResponse;
import com.deepak.ecommerce.ui.main.MainActivity;
import com.deepak.ecommerce.ui.products.ProductsFragment;

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
    private String mParam2;
    private FragmentChooseOptionsBinding binding;
    private MainActivity activity;

    public ChooseOptionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param apiResponse Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChooseOptionsFragment.
     */
    public static ChooseOptionsFragment newInstance(ApiResponse apiResponse, String param2) {
        ChooseOptionsFragment fragment = new ChooseOptionsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, apiResponse);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            apiResponse = (ApiResponse) getArguments().getSerializable(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choose_options, container, false);
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
        activity.replaceFragment(ProductsFragment.newInstance(apiResponse,""));
    }
}