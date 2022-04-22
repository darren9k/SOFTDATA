package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Page2 extends AppCompatActivity implements View.OnClickListener {

    private Button btTerminer;
    private RadioGroup rdInformation, rdProprete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        this.btTerminer =(Button)  findViewById(R.id.idTerminer);
        this.rdInformation =(RadioGroup) findViewById(R.id.idInformation);
        this.rdProprete = (RadioGroup) findViewById(R.id.idpreprete);

        this.btTerminer.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.idTerminer)
        {
            //on recuprere l'email et le rer
            String email = this.getIntent().getStringExtra("email").toString();
            String rer = this.getIntent().getStringExtra("rer").toString();

            //on calcule le score des reponses des questions
            int score =0;
            switch (this.rdProprete.getCheckedRadioButtonId()){
                case R.id.idpreprete1: score =16; break;
                case R.id.idpreprete2: score =12; break;
                case R.id.idpreprete3: score =8; break;
            }


            //on ajoute la reponse du condidat
            SNCF.getEnquete(rer).getCandidat(email).ajouterReponse("Proprete", score);

            switch (this.rdInformation.getCheckedRadioButtonId()){
                case R.id.idInformation1: score =16; break;
                case R.id.idInformation2: score =12; break;
                case R.id.idInformation3: score =8; break;
            }
            SNCF.getEnquete(rer).getCandidat(email).ajouterReponse("Information", score);

            //on passe a la page2
            Intent unIntent = new Intent(this, Page3.class);
            unIntent.putExtra("rer",rer);
            unIntent.putExtra("email", email);
            this.startActivity(unIntent);

        }
    }
}