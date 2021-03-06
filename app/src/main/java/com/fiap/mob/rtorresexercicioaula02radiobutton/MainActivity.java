package com.fiap.mob.rtorresexercicioaula02radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int intTotal = 0;
    private int intIdSelecionado;
    private RadioGroup rbPizzas;
    private CheckBox cbBorda;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMessage = (TextView) findViewById(R.id.tvTotal);
        rbPizzas = (RadioGroup) findViewById(R.id.rbGroup);
        cbBorda = (CheckBox) findViewById(R.id.cbBorda);

        rbPizzas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mtdValidarSelecao();
            }
        });
    }

    private void mtdValidarSelecao() {
        intIdSelecionado = rbPizzas.getCheckedRadioButtonId();
        RadioButton rbSelecao = (RadioButton) findViewById(intIdSelecionado);
        cbBorda.setChecked(false);
        cbBorda.setEnabled(!(rbSelecao == findViewById(R.id.rbMucarela)));
    }

    public void mtdCalcular(View v){
        intTotal = 0;
        intIdSelecionado = rbPizzas.getCheckedRadioButtonId();
        RadioButton rbSelecao = (RadioButton) findViewById(intIdSelecionado);
        intTotal = Integer.parseInt(rbSelecao.getTag().toString()) + (cbBorda.isChecked() ? Integer.parseInt(cbBorda.getTag().toString()) : 0);
        tvMessage.setText("Total: " + intTotal);
    }
}
