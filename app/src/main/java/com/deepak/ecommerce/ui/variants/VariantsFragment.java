package com.deepak.ecommerce.ui.variants;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.deepak.ecommerce.R;
import com.deepak.ecommerce.databinding.FragmentVariantsBinding;
import com.deepak.ecommerce.models.Variant;
import com.deepak.ecommerce.ui.main.MainActivity;
import com.deepak.ecommerce.utils.Constants;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link VariantsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VariantsFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<Variant>  listVariants;
    private int mParam2;
    private MainActivity activity;
    private FragmentVariantsBinding binding;

    public VariantsFragment() {
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
    public static VariantsFragment newInstance(List<Variant> apiResponse, int param2) {
        VariantsFragment fragment = new VariantsFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, (ArrayList<? extends Parcelable>) apiResponse);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listVariants = getArguments().getParcelableArrayList(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    private void setVisibility(int recycler, int textView, String txt) {
        binding.rvVariants.setVisibility(recycler);
        binding.linSearchTxt.setVisibility(textView);
        binding.tvMessage.setText(txt);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_variants, container, false);

        activity.setUpActionBar(getString(R.string.list_of_products));

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        binding.rvVariants.setLayoutManager(mLayoutManager);
        binding.rvVariants.setItemAnimator(new DefaultItemAnimator());

        if (listVariants.size() != 0) {
            setVisibility(View.VISIBLE, View.GONE, Constants.BLANK);
            VariantsAdapter mAdapter = new VariantsAdapter(listVariants);
            binding.rvVariants.setAdapter(mAdapter);
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