package br.com.whatsapp;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout input_layout_nume;
    private TextInputLayout input_layout_msg;

    private TextInputEditText input_edit_num;
    private TextInputEditText input_edit_msg;

    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_layout_msg = findViewById(R.id.input_layout_msg);
        input_layout_nume = findViewById(R.id.input_layout_nume);

        input_edit_msg = findViewById(R.id.input_edit_msg);
        input_edit_num = findViewById(R.id.input_edit_num);



        send = findViewById(R.id.btnSend);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String telefone = input_edit_num.getText().toString();
                String texto = input_edit_msg.getText().toString();

                String url = formatterUrl(telefone, texto);

                send(url);
            }
            public String formatterUrl(String telefone, String texto) {
                texto = texto.replace(" ", " %20");

                String link = "https://wa.me/" + telefone + "?text=" + texto;
                return link;
            }

            public void send(String url) {
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }

        });
    }
}