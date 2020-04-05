package pt.ipg.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_Value);
        this.mViewHolder.textDolar = findViewById(R.id.text_Dolar);
        this.mViewHolder.textReal = findViewById(R.id.text_Real);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_Calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();
    }

    private void clearValues() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textReal.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_Calculate){
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)){
                Toast.makeText(this, R.string.digite_valor, Toast.LENGTH_LONG).show();
            } else {
            Double euro = Double.valueOf(value);

                this.mViewHolder.textDolar.setText(String.format("%.2f", (euro * 1.08)));
                this.mViewHolder.textReal.setText(String.format("%.2f", (euro * 5.78)));
            }
        }
    }




    private static  class ViewHolder{
        EditText editValue;
        TextView textDolar;
        TextView textReal;
        Button buttonCalculate;
    }
}
