package com.example.taras.gascalculation.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.taras.gascalculation.R;
import com.example.taras.gascalculation.logic.GasDescription;
import com.example.taras.gascalculation.logic.Utils;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ResultFragment extends Fragment {
    private final static String CONSTANT_FOR_CET_TRANSACTION = "const";

    private OnFragmentInteractionListener mListener;

    public ResultFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.gas_calorific_ID)
    TextView gas_calorific;
    @BindView(R.id.gas_density_ID)
    TextView gas_density;
    @BindView(R.id.gas_tcoAir_ID)
    TextView gas_tcoAir;
    @BindView(R.id.gas_normalRate_ID)
    TextView gas_normalRate;
    @BindView(R.id.gas_lowerFL_ID)
    TextView gas_lowerFL;
    @BindView(R.id.gas_higherFT_ID)
    TextView gas_higherFT;

    @BindView(R.id.btn_back)
    Button btn_back;
    @BindView(R.id.btn_add)
    Button btn_add;

    @OnClick({R.id.btn_back, R.id.btn_add})
    public void Onclick(View view){
        switch (view.getId()){
            case R.id.btn_back:
                break;
            case R.id.btn_add:
                break;
        }
    }
    //TODO Где лучше обработать данные которые я получаю из InPutFragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        ButterKnife.bind(this, view);
        GasDescription gasDescription = new GasDescription();
        Bundle bundle = this.getArguments();
        if(bundle != null){
            gasDescription.setGasCH4(Double.parseDouble
                    (bundle.getString(ConstantForTransaction.CONST_METHANE)));
            gasDescription.setGasCO(Double.parseDouble
                    (bundle.getString(ConstantForTransaction.CONST_MONOXIDE)));
            gasDescription.setGasH2(Double.parseDouble
                    (bundle.getString(ConstantForTransaction.CONST_HYDROGEN)));
            gasDescription.setGasCO2(Double.parseDouble
                    (bundle.getString(ConstantForTransaction.CONST_DIOXIDE)));
            gasDescription.setGasN2(Double.parseDouble
                    (bundle.getString(ConstantForTransaction.CONST_NITROGEN)));
            gas_calorific.setText(bundle.getString(ConstantForTransaction.CONST_METHANE)+" "+bundle.getString(ConstantForTransaction.CONST_MONOXIDE)+" "+
                    bundle.getString(ConstantForTransaction.CONST_HYDROGEN)+" "+bundle.getString(ConstantForTransaction.CONST_DIOXIDE)+" "+
                    bundle.getString(ConstantForTransaction.CONST_NITROGEN));
        }
        gas_calorific.setText("trololo");
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    interface OnFragmentInteractionListener {
    }
}
