package com.example.taras.gascalculation.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.taras.gascalculation.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class InPutFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public InPutFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.editMethane_ID)
    EditText eMethane;
    @BindView(R.id.editMonoxideCarbon_ID)
    EditText eMonoCarbon;
    @BindView(R.id.editHydrogen_ID)
    EditText eHydrogen;
    @BindView(R.id.editDioxideCarbon_ID)
    EditText eDioCarbon;
    @BindView(R.id.editNitrogen_ID)
    EditText eNitrogen;

    @BindView(R.id.btn_about)
    Button btn_about;
    @BindView(R.id.btn_check)
    Button btn_check;
    @BindView(R.id.btn_getResult)
    Button btn_getResult;

    @OnClick({R.id.btn_about,R.id.btn_check,R.id.btn_getResult})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_about:
                Toast.makeText(getContext(), getString(R.string.for_btn_about), Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_check:
                break;
            case R.id.btn_getResult:
                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_launcher, container, false);
        ButterKnife.bind(this, view);
        //App Are crashing
        ArrayList<String> list = new ArrayList<>();
        list.add(eMethane.toString());
        list.add(eMonoCarbon.toString());
        list.add(eHydrogen.toString());
        list.add(eDioCarbon.toString());
        list.add(eNitrogen.toString());
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
        InputMethodManager inm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE) ;
        inm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        mListener = null;
    }

    interface OnFragmentInteractionListener {
    }
}
