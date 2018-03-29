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

public class ReceivePaymentsFragment extends Fragment {

    View rootView;

    @BindView(R.id.receive_payment_add_billing_address_text_view)
    TextView mAddBillingAddressTextView;

    @BindView(R.id.receive_payment_add_bank_account_text_view)
    TextView mAddBankAccountTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_receive_payments, container, false);
        ButterKnife.bind(this, rootView);

        initializeData();

        return rootView;
    }

    private void initializeData() {
        mAddBillingAddressTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mAddBankAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
