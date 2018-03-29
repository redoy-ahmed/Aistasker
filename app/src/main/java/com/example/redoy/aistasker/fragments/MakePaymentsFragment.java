package com.example.redoy.aistasker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.redoy.aistasker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Redoy on 3/30/2018.
 */

public class MakePaymentsFragment extends Fragment {

    View rootView;

    @BindView(R.id.make_payment_add_credit_card_text_view)
    TextView mAddCreditCardTextView;

    @BindView(R.id.make_payment_redeem_airtasker_card_text_view)
    TextView mRedeemAirtaskerCardTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_make_payment, container, false);
        ButterKnife.bind(this, rootView);
        initializeData();

        return rootView;
    }

    private void initializeData() {

        mAddCreditCardTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mRedeemAirtaskerCardTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
