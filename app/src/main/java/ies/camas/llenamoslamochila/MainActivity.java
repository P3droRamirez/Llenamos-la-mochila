package ies.camas.llenamoslamochila;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox gorras,baniadores,camisetas,zapatos,pantalones,libros;
    Button vaciarMochila;
    TextView pesoTotalView;

    private final int pesoGorras = 4;
    private final int pesoBanadores = 6;
    private final int pesoCamisetas = 7;
    private final int pesoZapatos = 4;
    private final int pesoPantalones = 5;
    private final int pesoLibros = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        gorras = findViewById(R.id.gorras);
        baniadores = findViewById(R.id.baniador);
        camisetas = findViewById(R.id.camisetas);
        zapatos = findViewById(R.id.zapatos);
        pantalones = findViewById(R.id.pantalones);
        libros = findViewById(R.id.libros);
        vaciarMochila = findViewById(R.id.vaciarMochila);
        pesoTotalView = findViewById(R.id.pesoTotal);

        gorras.setOnCheckedChangeListener((buttonView, isChecked) -> calcularPesoMochila());
        baniadores.setOnCheckedChangeListener((buttonView, isChecked) -> calcularPesoMochila());
        camisetas.setOnCheckedChangeListener((buttonView, isChecked) -> calcularPesoMochila());
        zapatos.setOnCheckedChangeListener((buttonView, isChecked) -> calcularPesoMochila());
        pantalones.setOnCheckedChangeListener((buttonView, isChecked) -> calcularPesoMochila());
        libros.setOnCheckedChangeListener((buttonView, isChecked) -> calcularPesoMochila());

        vaciarMochila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gorras.setChecked(false);
                baniadores.setChecked(false);
                camisetas.setChecked(false);
                zapatos.setChecked(false);
                pantalones.setChecked(false);
                libros.setChecked(false);
                pesoTotalView.setText("");

                calcularPesoMochila();
            }
        });
    }
    private void calcularPesoMochila(){
        int pesoTotal = 0;

        if(gorras.isChecked())pesoTotal = pesoTotal + pesoGorras;
        if(baniadores.isChecked()) pesoTotal = pesoTotal + pesoBanadores;
        if(camisetas.isChecked())pesoTotal = pesoTotal + pesoCamisetas;
        if(zapatos.isChecked())pesoTotal = pesoTotal + pesoZapatos;
        if(pantalones.isChecked())pesoTotal = pesoTotal + pesoPantalones;
        if(libros.isChecked())pesoTotal = pesoTotal + pesoLibros;

        pesoTotalView.setText("Peso : " + pesoTotal + " Kg");

        if(pesoTotal > 20){
            pesoTotalView.setTextColor(Color.RED);
        }else{
            pesoTotalView.setTextColor(Color.BLACK);
        }

    }

}