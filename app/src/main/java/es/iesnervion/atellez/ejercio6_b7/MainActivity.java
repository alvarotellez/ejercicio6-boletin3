package es.iesnervion.atellez.ejercio6_b7;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText destinatario, asunto, cuerpo;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        destinatario = (EditText) findViewById(R.id.correoEnvio);
        asunto = (EditText) findViewById(R.id.asuntoEnvio);
        cuerpo = (EditText) findViewById(R.id.cuerpo);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtenemos el valor del editText
                String emailEnvio = destinatario.getText().toString();
                String asuntoEmail = asunto.getText().toString();
                String cuerpoEmail = cuerpo.getText().toString();

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, emailEnvio);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, asuntoEmail);
                emailIntent.putExtra(Intent.EXTRA_TEXT, cuerpoEmail);
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Email "));
            }
        });
    }
}

