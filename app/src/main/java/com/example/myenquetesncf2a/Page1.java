package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Page1 extends AppCompatActivity implements View.OnClickListener {

    private Button btSuivant ;
    private RadioGroup rdPonctualite, rdService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        this.btSuivant = (Button) findViewById(R.id.idSuivant1);
        this.rdPonctualite = (RadioGroup) findViewById(R.id.idpreprete);
        this.rdService =(RadioGroup) findViewById(R.id.idInformation);

        this.btSuivant.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.idSuivant1)
        {

            String email = this.getIntent().getStringExtra("email").toString();
            String rer = this.getIntent().getStringExtra("rer").toString();

            //on calcule le score des reponses des questions
            int score =0;
            switch (this.rdPonctualite.getCheckedRadioButtonId()){
                case R.id.idponctualite1: score =16; break;
                case R.id.idponctualite2: score =12; break;
                case R.id.idponctualite3: score =8; break;
            }


            //on ajoute la reponse du condidat
            SNCF.getEnquete(rer).getCandidat(email).ajouterReponse("Ponctualite", score);

            switch (this.rdService.getCheckedRadioButtonId()){
                case R.id.idService1: score =16; break;
                case R.id.idService2: score =12; break;
                case R.id.idService3: score =8; break;
            }
            SNCF.getEnquete(rer).getCandidat(email).ajouterReponse("Service", score);



            //on passe a la page2
            Intent unIntent = new Intent(this, Page2.class);
            unIntent.putExtra("rer",rer);
            unIntent.putExtra("email", email);
            this.startActivity(unIntent);

        }

    }
}