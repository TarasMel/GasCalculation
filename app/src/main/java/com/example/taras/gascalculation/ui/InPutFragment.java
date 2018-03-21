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
import com.example.taras.gascalculation.logic.Utils;
import com.example.taras.gascalculation.logic.GasDescription;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class InPutFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private GasDescription gasDescription = new GasDescription();//обьявил глобально чтобы не крашилось при нажатии на Чек

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
                if (Utils.checkingAdding(gasDescription)){
                    Toast.makeText(getContext(), "if", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getContext(), "else", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_getResult:
                //TODO Принажатии передает данные в ResultFragment
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
        // TODO Где лучше сделать иницилизацию объекта, чтобы можно было использовать его можно было использовать button btn_check
        /*gasDescription = new GasDescription(Double.parseDouble(eMethane.toString()),Double.parseDouble(eMonoCarbon.toString()),
                Double.parseDouble(eHydrogen.toString()),Double.parseDouble(eDioCarbon.toString()),Double.parseDouble(eNitrogen.toString()));*/

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
