package com.yousuf.fragmentsanime.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.yousuf.fragmentsanime.R;
import com.yousuf.fragmentsanime.interfaces.MediatorInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }

    private MediatorInterface mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MediatorInterface) {
            mListener = (MediatorInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement MediatorInterface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_first, container, false);

        Button btnNext = parentView.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.changeFragmentTo(new SecondFragment(), SecondFragment.class.getSimpleName());
                }
            }
        });

        return parentView;
    }

}
