package com.example.taras.gascalculation.AppUI;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.taras.gascalculation.R;

import butterknife.BindView;



public class InPutFragment extends Fragment {

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

    private OnFragmentInteractionListener mListener;

    public InPutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_launcher, container, false);
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
