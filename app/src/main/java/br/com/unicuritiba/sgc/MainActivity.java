package br.com.unicuritiba.sgc;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import br.com.unicuritiba.sgc.models.ConversorBitcoin;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editBitcoin;
    private MaterialButton btnConverter;
    private TextView txtResultado;
    private ConversorBitcoin conversor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conversor = new ConversorBitcoin();

        editBitcoin = findViewById(R.id.editBitcoin);
        btnConverter = findViewById(R.id.btnConverter);
        txtResultado = findViewById(R.id.txtResultado);

        btnConverter.setOnClickListener(v -> realizarConversao());
    }

    private void realizarConversao() {
        String strBtc = editBitcoin.getText() != null ? editBitcoin.getText().toString().trim() : "";

        if (strBtc.isEmpty()) {
            Toast.makeText(this, "Digite a quantidade em Bitcoin!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double btc = Double.parseDouble(strBtc.replace(",", "."));
            double valorFinal = conversor.converterBtcParaBrl(btc);

            txtResultado.setText(ConversorBitcoin.formatarReais(valorFinal));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, digite um número válido.", Toast.LENGTH_SHORT).show();
        } catch (IllegalArgumentException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
